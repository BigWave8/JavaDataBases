package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.ParcelDAOimpl;
import com.oryshchak.businesslogic.model.Parcel;
import com.oryshchak.businesslogic.service.ParcelService;

public class ParcelServiceImpl implements ParcelService {

  private GeneralDAO<Parcel, String> entityDAO;

  @Override
  public GeneralDAO<Parcel, String> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new ParcelDAOimpl();
    }
    return entityDAO;
  }
}
