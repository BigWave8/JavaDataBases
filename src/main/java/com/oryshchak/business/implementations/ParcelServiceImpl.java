package com.oryshchak.business.implementations;

import com.oryshchak.business.ParcelService;
import com.oryshchak.dao.GeneralDao;
import com.oryshchak.dao.implementations.ParcelDaoImpl;
import com.oryshchak.model.Parcel;

public class ParcelServiceImpl implements ParcelService {

  private GeneralDao<Parcel, String> entityDao;

  @Override
  public GeneralDao<Parcel, String> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new ParcelDaoImpl();
    }
    return entityDao;
  }
}
