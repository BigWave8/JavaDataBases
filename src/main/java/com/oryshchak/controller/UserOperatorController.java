package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.UserOperator;
import com.oryshchak.businesslogic.service.implementations.UserOperatorServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class UserOperatorController {
  public List<UserOperator> getUserOperator() throws SQLException {
    return new UserOperatorServiceImpl().findAll();
  }

  public UserOperator getUserOperator(Integer id) throws SQLException {
    return new UserOperatorServiceImpl().findById(id);
  }

  public int setUserOperator(UserOperator userOperator) throws SQLException {
    return new UserOperatorServiceImpl().create(userOperator);
  }

  public int putUserOperator(UserOperator userOperator) throws SQLException {
    return new UserOperatorServiceImpl().update(userOperator);
  }

  public int removeUserOperator(Integer id) throws SQLException {
    return new UserOperatorServiceImpl().delete(id);
  }
}
