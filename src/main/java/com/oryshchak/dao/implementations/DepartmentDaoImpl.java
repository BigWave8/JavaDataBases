package com.oryshchak.dao.implementations;

import com.oryshchak.dao.DepartmentDao;
import com.oryshchak.dao.queries.QueryGenerator;

public class DepartmentDaoImpl implements DepartmentDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Department");
    }
    return queryGenerator;
  }
}
