package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.DepartmentDAOimpl;
import com.oryshchak.businesslogic.model.Department;
import com.oryshchak.businesslogic.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

  private GeneralDAO<Department, Integer> entityDAO;

  @Override
  public GeneralDAO<Department, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new DepartmentDAOimpl();
    }
    return entityDAO;
  }
}
