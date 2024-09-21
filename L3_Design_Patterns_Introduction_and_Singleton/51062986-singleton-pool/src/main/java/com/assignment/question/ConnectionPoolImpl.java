package com.assignment.question;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPoolImpl implements ConnectionPool {
  private static ConnectionPoolImpl connectionPoolImpl;
  private final int maxConnections;
  private Queue<DatabaseConnection> availableConnections;

  private ConnectionPoolImpl(int maxConnections) {
    this.maxConnections = maxConnections;
    availableConnections = new LinkedList<>();
    initializePool();
  }

  @Override
  public void initializePool() {
    for (int connection = 1; connection <= maxConnections; connection++) {
      availableConnections.add(new DatabaseConnection());
    }
  }

  @Override
  public DatabaseConnection getConnection() {
    return availableConnections.poll();
  }

  @Override
  public void releaseConnection(DatabaseConnection connection) {
    availableConnections.add(connection);
  }

  @Override
  public int getAvailableConnectionsCount() {
    return availableConnections.size();
  }

  @Override
  public int getTotalConnectionsCount() {
    return maxConnections;
  }

  public static ConnectionPool getInstance(int maxConnections) {
    if (connectionPoolImpl != null) {
      return connectionPoolImpl;
    }

    synchronized (ConnectionPoolImpl.class) {
      if (connectionPoolImpl == null) {
        connectionPoolImpl = new ConnectionPoolImpl(maxConnections);
      }
    }
    return connectionPoolImpl;
  }

  public static void resetInstance() {
    connectionPoolImpl = null;
  }
}