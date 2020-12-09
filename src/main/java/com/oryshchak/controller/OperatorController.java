package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.Operator;
import com.oryshchak.businesslogic.service.implementations.OperatorServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class OperatorController {
  public List<Operator> getOperator() throws SQLException {
    return new OperatorServiceImpl().findAll();
  }

  public Operator getOperator(Integer id) throws SQLException {
    return new OperatorServiceImpl().findById(id);
  }

  public int setOperator(Operator operator) throws SQLException {
    return new OperatorServiceImpl().create(operator);
  }

  public int putOperator(Operator operator) throws SQLException {
    return new OperatorServiceImpl().update(operator);
  }

  public int removeOperator(Integer id) throws SQLException {
    return new OperatorServiceImpl().delete(id);
  }
}
