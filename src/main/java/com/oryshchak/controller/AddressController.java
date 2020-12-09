package com.oryshchak.controller;

import com.oryshchak.businesslogic.model.Address;
import com.oryshchak.businesslogic.service.implementations.AddressServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class AddressController {
  public List<Address> getAddress() throws SQLException {
    return new AddressServiceImpl().findAll();
  }

  public Address getAddress(Integer id) throws SQLException {
    return new AddressServiceImpl().findById(id);
  }

  public int setAddress(Address address) throws SQLException {
    return new AddressServiceImpl().create(address);
  }

  public int putAddress(Address address) throws SQLException {
    return new AddressServiceImpl().update(address);
  }

  public int removeAddress(Integer id) throws SQLException {
    return new AddressServiceImpl().delete(id);
  }
}
