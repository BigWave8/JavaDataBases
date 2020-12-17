package com.oryshchak.dao.implementations;

import com.oryshchak.dao.OperatorDao;
import com.oryshchak.dao.queries.QueryGenerator;

public class OperatorDaoImpl implements OperatorDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Operator");
    }
    return queryGenerator;
  }
}
