package com.oryshchak.business.implementations;

import com.oryshchak.business.CourierService;
import com.oryshchak.dao.GeneralDao;
import com.oryshchak.dao.implementations.CourierDaoImpl;
import com.oryshchak.model.Courier;

public class CourierServiceImpl implements CourierService {

  private GeneralDao<Courier, Integer> entityDao;

  @Override
  public GeneralDao<Courier, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new CourierDaoImpl();
    }
    return entityDao;
  }
}
