package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.OperatorDAOimpl;
import com.oryshchak.businesslogic.model.Operator;
import com.oryshchak.businesslogic.service.OperatorService;

public class OperatorServiceImpl implements OperatorService {

  private GeneralDAO<Operator, Integer> entityDAO;

  @Override
  public GeneralDAO<Operator, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new OperatorDAOimpl();
    }
    return entityDAO;
  }
}
