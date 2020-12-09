package com.oryshchak.businesslogic.service.implementations;

import com.oryshchak.businesslogic.datalayer.GeneralDAO;
import com.oryshchak.businesslogic.datalayer.implementations.RegionDAOimpl;
import com.oryshchak.businesslogic.model.Region;
import com.oryshchak.businesslogic.service.RegionService;

public class RegionServiceImpl implements RegionService {

  private GeneralDAO<Region, Integer> entityDAO;

  @Override
  public GeneralDAO<Region, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new RegionDAOimpl();
    }
    return entityDAO;
  }
}
