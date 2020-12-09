package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.UserOperatorDAOimpl;
import com.oryshchak.businesslogic.model.UserOperator;
import com.oryshchak.businesslogic.service.UserOperatorService;

public class UserOperatorServiceImpl implements UserOperatorService {

  private GeneralDAO<UserOperator, Integer> entityDAO;

  @Override
  public GeneralDAO<UserOperator, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new UserOperatorDAOimpl();
    }
    return entityDAO;
  }
}
