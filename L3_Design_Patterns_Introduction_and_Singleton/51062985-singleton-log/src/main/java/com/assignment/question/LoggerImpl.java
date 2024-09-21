package com.assignment.question;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.springframework.boot.logging.LogLevel;

public class LoggerImpl implements Logger {

  private static LoggerImpl loggerImpl;
  PrintWriter printWriter;
  FileWriter fileWriter;
  String filePath;

  private LoggerImpl() {
  }

  @Override
  public void log(LogLevel level, String message) {
    if (printWriter == null) {
      throw new IllegalStateException();
    }

    printWriter.append(level.toString());
    printWriter.append(message);
  }

  @Override
  public void setLogFile(String filePath) {

    try {
      this.filePath = filePath;
      fileWriter = new FileWriter(filePath);
      printWriter = new PrintWriter(fileWriter);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getLogFile() {
    return filePath;
  }

  @Override
  public void flush() {
    printWriter.flush();
  }

  @Override
  public void close() {
    printWriter.close();
  }

  public static LoggerImpl getInstance() {
    if (loggerImpl != null) {
      return loggerImpl;
    }

    synchronized (LoggerImpl.class) {
      if (loggerImpl == null) {
        loggerImpl = new LoggerImpl();
      }
    }

    return loggerImpl;
  }

  public static void resetInstance() {
    loggerImpl = null;
  }
}