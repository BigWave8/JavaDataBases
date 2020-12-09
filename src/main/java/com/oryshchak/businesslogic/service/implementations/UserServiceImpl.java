package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.UserDAOimpl;
import com.oryshchak.businesslogic.model.User;
import com.oryshchak.businesslogic.service.UserService;

public class UserServiceImpl implements UserService {

  private GeneralDAO<User, Integer> entityDAO;

  @Override
  public GeneralDAO<User, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new UserDAOimpl();
    }
    return entityDAO;
  }
}
