package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.CityDAOimpl;
import com.oryshchak.businesslogic.model.City;
import com.oryshchak.businesslogic.service.CityService;

public class CityServiceImpl implements CityService {

  private GeneralDAO<City, Integer> entityDAO;

  @Override
  public GeneralDAO<City, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new CityDAOimpl();
    }
    return entityDAO;
  }
}
