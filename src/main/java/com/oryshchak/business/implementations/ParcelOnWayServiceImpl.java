package com.oryshchak.business.implementations;

import com.oryshchak.business.ParcelOnWayService;
import com.oryshchak.dao.GeneralDao;
import com.oryshchak.dao.implementations.ParcelOnWayDaoImpl;
import com.oryshchak.model.ParcelOnWay;

public class ParcelOnWayServiceImpl implements ParcelOnWayService {

  private GeneralDao<ParcelOnWay, Integer> entityDao;

  @Override
  public GeneralDao<ParcelOnWay, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new ParcelOnWayDaoImpl();
    }
    return entityDao;
  }
}
