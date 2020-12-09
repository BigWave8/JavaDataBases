package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.ParcelOnWayDAOimpl;
import com.oryshchak.businesslogic.model.ParcelOnWay;
import com.oryshchak.businesslogic.service.ParcelOnWayService;

public class ParcelOnWayServiceImpl implements ParcelOnWayService {

  private GeneralDAO<ParcelOnWay, Integer> entityDAO;

  @Override
  public GeneralDAO<ParcelOnWay, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new ParcelOnWayDAOimpl();
    }
    return entityDAO;
  }
}
