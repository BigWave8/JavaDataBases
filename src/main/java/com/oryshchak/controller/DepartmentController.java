package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.Department;
import com.oryshchak.businesslogic.service.implementations.DepartmentServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class DepartmentController {
  public List<Department> getDepartment() throws SQLException {
    return new DepartmentServiceImpl().findAll();
  }

  public Department getDepartment(Integer id) throws SQLException {
    return new DepartmentServiceImpl().findById(id);
  }

  public int setDepartment(Department department) throws SQLException {
    return new DepartmentServiceImpl().create(department);
  }

  public int putDepartment(Department department) throws SQLException {
    return new DepartmentServiceImpl().update(department);
  }

  public int removeDepartment(Integer id) throws SQLException {
    return new DepartmentServiceImpl().delete(id);
  }
}
