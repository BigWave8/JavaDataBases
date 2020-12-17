package com.oryshchak.dao.implementations;

import com.oryshchak.dao.CourierDao;
import com.oryshchak.dao.queries.QueryGenerator;

public class CourierDaoImpl implements CourierDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Courier");
    }
    return queryGenerator;
  }
}
