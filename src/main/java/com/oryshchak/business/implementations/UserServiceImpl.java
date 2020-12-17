package com.oryshchak.business.implementations;

import com.oryshchak.business.UserService;
import com.oryshchak.dao.GeneralDao;
import com.oryshchak.dao.implementations.UserDaoImpl;
import com.oryshchak.model.User;

public class UserServiceImpl implements UserService {

  private GeneralDao<User, Integer> entityDao;

  @Override
  public GeneralDao<User, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new UserDaoImpl();
    }
    return entityDao;
  }
}
