package com.oryshchak.dao.implementations;

import com.oryshchak.dao.CityDao;
import com.oryshchak.dao.queries.QueryGenerator;

public class CityDaoImpl implements CityDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("City");
    }
    return queryGenerator;
  }
}
