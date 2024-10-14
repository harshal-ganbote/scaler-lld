package com.assignment.question;

import java.util.HashMap;


public class UserPrototypeRegistryImpl implements UserPrototypeRegistry {

  private final HashMap<UserType, User> prototypes = new HashMap<>();

  @Override
  public void addPrototype(User user) {
    prototypes.put(user.getType(), user);
  }

  @Override
  public User getPrototype(UserType type) {
    return prototypes.getOrDefault(type, null);
  }

  @Override
  public User clone(UserType type) {
    User user = prototypes.getOrDefault(type, null);

    if (user == null) {
      return null;
    }

    return user.cloneObject();
  }

}
