package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.Courier;
import com.oryshchak.businesslogic.service.implementations.CourierServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class CourierController {
  public List<Courier> getCourier() throws SQLException {
    return new CourierServiceImpl().findAll();
  }

  public Courier getCourier(Integer id) throws SQLException {
    return new CourierServiceImpl().findById(id);
  }

  public int setCourier(Courier courier) throws SQLException {
    return new CourierServiceImpl().create(courier);
  }

  public int putCourier(Courier courier) throws SQLException {
    return new CourierServiceImpl().update(courier);
  }

  public int removeCourier(Integer id) throws SQLException {
    return new CourierServiceImpl().delete(id);
  }
}
