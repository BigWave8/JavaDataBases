package com.oryshchak.business;

import com.oryshchak.dao.GeneralDao;
import java.sql.SQLException;
import java.util.List;

public interface GeneralService<T, Id> {

  GeneralDao<T, Id> giveDaoObject();

  default List<T> findAll() throws SQLException {
    return giveDaoObject().findAll();
  }

  default T findById(Id id) throws SQLException {
    return giveDaoObject().findById(id);
  }

  default int create(T entity) throws SQLException {
    return giveDaoObject().create(entity);
  }

  default void update(T entity) throws SQLException {
    giveDaoObject().update(entity);
  }

  default int delete(Id id) throws SQLException {
    return giveDaoObject().delete(id);
  }
}
