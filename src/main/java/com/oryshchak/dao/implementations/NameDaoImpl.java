package com.oryshchak.dao.implementations;

import com.oryshchak.dao.NameDao;
import com.oryshchak.dao.queries.QueryGenerator;

public class NameDaoImpl implements NameDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Name");
    }
    return queryGenerator;
  }
}
