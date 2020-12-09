package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.User;
import com.oryshchak.businesslogic.service.implementations.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class UserController {
  public List<User> getUser() throws SQLException {
    return new UserServiceImpl().findAll();
  }

  public User getUser(Integer id) throws SQLException {
    return new UserServiceImpl().findById(id);
  }

  public int setUser(User user) throws SQLException {
    return new UserServiceImpl().create(user);
  }

  public int putUser(User user) throws SQLException {
    return new UserServiceImpl().update(user);
  }

  public int removeUser(Integer id) throws SQLException {
    return new UserServiceImpl().delete(id);
  }
}
