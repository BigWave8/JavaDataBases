package com.oryshchak.business.implementations;

import com.oryshchak.business.NameService;
import com.oryshchak.dao.GeneralDao;
import com.oryshchak.dao.implementations.NameDaoImpl;
import com.oryshchak.model.Name;

public class NameServiceImpl implements NameService {

  private GeneralDao<Name, Integer> entityDao;

  @Override
  public GeneralDao<Name, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new NameDaoImpl();
    }
    return entityDao;
  }
}
