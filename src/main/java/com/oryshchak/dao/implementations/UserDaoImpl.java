package com.oryshchak.dao.implementations;

import com.oryshchak.dao.UserDao;
import com.oryshchak.dao.queries.QueryGenerator;

public class UserDaoImpl implements UserDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("User");
    }
    return queryGenerator;
  }
}
