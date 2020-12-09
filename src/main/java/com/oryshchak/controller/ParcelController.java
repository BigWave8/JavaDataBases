package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.Parcel;
import com.oryshchak.businesslogic.service.implementations.ParcelServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ParcelController {
  public List<Parcel> getParcel() throws SQLException {
    return new ParcelServiceImpl().findAll();
  }

  public Parcel getParcel(String id) throws SQLException {
    return new ParcelServiceImpl().findById(id);
  }

  public int setParcel(Parcel parcel) throws SQLException {
    return new ParcelServiceImpl().create(parcel);
  }

  public int putParcel(Parcel parcel) throws SQLException {
    return new ParcelServiceImpl().update(parcel);
  }

  public int removeParcel(String id) throws SQLException {
    return new ParcelServiceImpl().delete(id);
  }
}
