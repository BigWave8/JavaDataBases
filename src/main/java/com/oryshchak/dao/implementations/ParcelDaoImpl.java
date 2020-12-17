package com.oryshchak.dao.implementations;

import com.oryshchak.dao.ParcelDao;
import com.oryshchak.dao.queries.QueryGenerator;

public class ParcelDaoImpl implements ParcelDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Parcel");
    }
    return queryGenerator;
  }
}
