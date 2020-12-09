package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.ParcelOnWay;
import com.oryshchak.businesslogic.service.implementations.ParcelOnWayServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ParcelOnWayController {
  public List<ParcelOnWay> getParcelOnWay() throws SQLException {
    return new ParcelOnWayServiceImpl().findAll();
  }

  public ParcelOnWay getParcelOnWay(Integer id) throws SQLException {
    return new ParcelOnWayServiceImpl().findById(id);
  }

  public int setParcelOnWay(ParcelOnWay parcelOnWay) throws SQLException {
    return new ParcelOnWayServiceImpl().create(parcelOnWay);
  }

  public int putParcelOnWay(ParcelOnWay parcelOnWay) throws SQLException {
    return new ParcelOnWayServiceImpl().update(parcelOnWay);
  }

  public int removeParcelOnWay(Integer id) throws SQLException {
    return new ParcelOnWayServiceImpl().delete(id);
  }
}
