package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.CourierDAOimpl;
import com.oryshchak.businesslogic.model.Courier;
import com.oryshchak.businesslogic.service.CourierService;

public class CourierServiceImpl implements CourierService {

  private GeneralDAO<Courier, Integer> entityDAO;

  @Override
  public GeneralDAO<Courier, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new CourierDAOimpl();
    }
    return entityDAO;
  }
}
