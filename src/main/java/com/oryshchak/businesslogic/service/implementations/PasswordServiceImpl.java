package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.PasswordDAOimpl;
import com.oryshchak.businesslogic.model.Password;
import com.oryshchak.businesslogic.service.PasswordService;

public class PasswordServiceImpl implements PasswordService {

  private GeneralDAO<Password, Integer> entityDAO;

  @Override
  public GeneralDAO<Password, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new PasswordDAOimpl();
    }
    return entityDAO;
  }
}
