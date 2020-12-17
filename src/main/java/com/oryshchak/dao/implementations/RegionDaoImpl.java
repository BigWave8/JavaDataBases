package com.oryshchak.dao.implementations;

import com.oryshchak.dao.RegionDao;
import com.oryshchak.dao.queries.QueryGenerator;

public class RegionDaoImpl implements RegionDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Region");
    }
    return queryGenerator;
  }
}
