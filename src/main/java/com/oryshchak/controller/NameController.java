package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.Name;
import com.oryshchak.businesslogic.service.implementations.NameServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class NameController {
  public List<Name> getName() throws SQLException {
    return new NameServiceImpl().findAll();
  }

  public Name getName(Integer id) throws SQLException {
    return new NameServiceImpl().findById(id);
  }

  public int setName(Name name) throws SQLException {
    return new NameServiceImpl().create(name);
  }

  public int putName(Name name) throws SQLException {
    return new NameServiceImpl().update(name);
  }

  public int removeName(Integer id) throws SQLException {
    return new NameServiceImpl().delete(id);
  }
}
