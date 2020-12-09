package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.City;
import com.oryshchak.businesslogic.service.implementations.CityServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class CityController {
  public List<City> getCity() throws SQLException {
    return new CityServiceImpl().findAll();
  }

  public City getCity(Integer id) throws SQLException {
    return new CityServiceImpl().findById(id);
  }

  public int setCity(City city) throws SQLException {
    return new CityServiceImpl().create(city);
  }

  public int putCity(City city) throws SQLException {
    return new CityServiceImpl().update(city);
  }

  public int removeCity(Integer id) throws SQLException {
    return new CityServiceImpl().delete(id);
  }
}
