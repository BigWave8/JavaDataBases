package com.oryshchak.business.implementations;

import com.oryshchak.business.OperatorService;
import com.oryshchak.dao.GeneralDao;
import com.oryshchak.dao.implementations.OperatorDaoImpl;
import com.oryshchak.model.Operator;

public class OperatorServiceImpl implements OperatorService {

  private GeneralDao<Operator, Integer> entityDao;

  @Override
  public GeneralDao<Operator, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new OperatorDaoImpl();
    }
    return entityDao;
  }
}
