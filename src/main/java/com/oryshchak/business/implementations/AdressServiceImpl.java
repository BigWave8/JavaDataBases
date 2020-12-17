package com.oryshchak.business.implementations;

import com.oryshchak.business.AdressService;
import com.oryshchak.dao.GeneralDao;
import com.oryshchak.dao.implementations.AdressDaoImpl;
import com.oryshchak.model.Adress;

public class AdressServiceImpl implements AdressService {

  private GeneralDao<Adress, Integer> entityDao;

  @Override
  public GeneralDao<Adress, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new AdressDaoImpl();
    }
    return entityDao;
  }
}
