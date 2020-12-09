package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.Region;
import com.oryshchak.businesslogic.service.implementations.RegionServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class RegionController {
  public List<Region> getRegion() throws SQLException {
    return new RegionServiceImpl().findAll();
  }

  public Region getRegion(Integer id) throws SQLException {
    return new RegionServiceImpl().findById(id);
  }

  public int setRegion(Region region) throws SQLException {
    return new RegionServiceImpl().create(region);
  }

  public int putRegion(Region region) throws SQLException {
    return new RegionServiceImpl().update(region);
  }

  public int removeRegion(Integer id) throws SQLException {
    return new RegionServiceImpl().delete(id);
  }
}
