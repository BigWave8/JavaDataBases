package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.NameDAOimpl;
import com.oryshchak.businesslogic.model.Name;
import com.oryshchak.businesslogic.service.NameService;

public class NameServiceImpl implements NameService {

  private GeneralDAO<Name, Integer> entityDAO;

  @Override
  public GeneralDAO<Name, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new NameDAOimpl();
    }
    return entityDAO;
  }
}
