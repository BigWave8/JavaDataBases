package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.AddressDAOimpl;
import com.oryshchak.businesslogic.model.Address;
import com.oryshchak.businesslogic.service.AddressService;

public class AddressServiceImpl implements AddressService {

  private GeneralDAO<Address, Integer> entityDAO;

  @Override
  public GeneralDAO<Address, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new AddressDAOimpl();
    }
    return entityDAO;
  }
}
