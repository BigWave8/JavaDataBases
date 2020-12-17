package com.oryshchak.business.implementations;

import com.oryshchak.business.RegionService;
import com.oryshchak.dao.GeneralDao;
import com.oryshchak.dao.implementations.RegionDaoImpl;
import com.oryshchak.model.Region;

public class RegionServiceImpl implements RegionService {

  private GeneralDao<Region, Integer> entityDao;

  @Override
  public GeneralDao<Region, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new RegionDaoImpl();
    }
    return entityDao;
  }
}
