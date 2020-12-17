package com.oryshchak.dao.implementations;

import com.oryshchak.dao.AdressDao;
import com.oryshchak.dao.queries.QueryGenerator;

public class AdressDaoImpl implements AdressDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Adress");
    }
    return queryGenerator;
  }
}
