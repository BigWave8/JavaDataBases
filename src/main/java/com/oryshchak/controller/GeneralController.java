package com.oryshchak.controller;

import com.oryshchak.business.GeneralService;
import com.oryshchak.view.Printable;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface GeneralController<T, Id> {

  GeneralService<T, Id> getService();

  void printHeaders();

  T inputEntity() throws SQLException, IOException;

  T inputCreateEntity() throws SQLException, IOException;

  Id getId();

  default void getEntities() throws SQLException {
    List<T> entities = getService().findAll();
    printHeaders();
    for (T entity : entities) {
      System.out.println(entity);
    }
  }

  default Printable getEntity() throws SQLException {
    Id id = getId();
    T entity = getService().findById(id);
    printHeaders();
    System.out.println(entity);
    return null;
  }

  default void setEntity() throws SQLException, IOException {
    T entity = inputEntity();
    System.out.println(getService().create(entity));
  }

  default void putEntity() throws SQLException, IOException {
    T entity = inputCreateEntity();
    getService().update(entity);
  }

  default int removeEntity() throws SQLException {
    Id id = getId();
    return getService().delete(id);
  }
}