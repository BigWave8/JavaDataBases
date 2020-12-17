package com.oryshchak.dao.implementations;

import com.oryshchak.dao.ParcelOnWayDao;
import com.oryshchak.dao.queries.QueryGenerator;

public class ParcelOnWayDaoImpl implements ParcelOnWayDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("ParcelOnWay");
    }
    return queryGenerator;
  }
}
