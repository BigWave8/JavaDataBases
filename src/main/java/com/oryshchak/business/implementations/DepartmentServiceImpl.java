package com.oryshchak.business.implementations;

import com.oryshchak.business.DepartmentService;
import com.oryshchak.dao.GeneralDao;
import com.oryshchak.dao.implementations.DepartmentDaoImpl;
import com.oryshchak.model.Department;

public class DepartmentServiceImpl implements DepartmentService {

  private GeneralDao<Department, Integer> entityDao;

  @Override
  public GeneralDao<Department, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new DepartmentDaoImpl();
    }
    return entityDao;
  }
}
