package com.assignment.question;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

  private static FileBasedConfigurationManagerImpl fileBasedConfigurationManagerImpl;

  private FileBasedConfigurationManagerImpl() {
  }

  @Override
  public String getConfiguration(String key) {
    return getProperties().getProperty(key);
  }

  @Override
  public <T> T getConfiguration(String key, Class<T> type) {
    String value = getProperties().getProperty(key);
    return convert(value, type);
  }

  @Override
  public void setConfiguration(String key, String value) {
    getProperties().setProperty(key, value);
  }

  @Override
  public <T> void setConfiguration(String key, T value) {
    getProperties().setProperty(key, value.toString());
  }

  @Override
  public void removeConfiguration(String key) {
    getProperties().remove(key);
  }

  @Override
  public void clear() {
    getProperties().clear();
  }

  public static FileBasedConfigurationManager getInstance() {
    if (fileBasedConfigurationManagerImpl != null) {
      return fileBasedConfigurationManagerImpl;
    }

    synchronized (FileBasedConfigurationManagerImpl.class) {
      if (fileBasedConfigurationManagerImpl == null) {
        fileBasedConfigurationManagerImpl = new FileBasedConfigurationManagerImpl();
      }
    }

    return fileBasedConfigurationManagerImpl;
  }

  public static void resetInstance() {
    fileBasedConfigurationManagerImpl = null;
  }

}