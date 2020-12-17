package com.oryshchak.business.implementations;

import com.oryshchak.business.CityService;
import com.oryshchak.dao.GeneralDao;
import com.oryshchak.dao.implementations.CityDaoImpl;
import com.oryshchak.model.City;

public class CityServiceImpl implements CityService {

  private GeneralDao<City, Integer> entityDao;

  @Override
  public GeneralDao<City, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new CityDaoImpl();
    }
    return entityDao;
  }
}
