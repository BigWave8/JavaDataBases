package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.Password;
import com.oryshchak.businesslogic.service.implementations.PasswordServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class PasswordController {
  public List<Password> getPassword() throws SQLException {
    return new PasswordServiceImpl().findAll();
  }

  public Password getPassword(Integer id) throws SQLException {
    return new PasswordServiceImpl().findById(id);
  }

  public int setPassword(Password password) throws SQLException {
    return new PasswordServiceImpl().create(password);
  }

  public int putPassword(Password password) throws SQLException {
    return new PasswordServiceImpl().update(password);
  }

  public int removePassword(Integer id) throws SQLException {
    return new PasswordServiceImpl().delete(id);
  }
}
