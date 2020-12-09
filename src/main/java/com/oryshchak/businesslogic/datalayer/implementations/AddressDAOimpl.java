package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.AddressDAO;
import com.oryshchak.businesslogic.model.Address;
import com.oryshchak.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAOimpl implements AddressDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM adress";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM adress WHERE adress.id = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT adress(street,house_number,apartment_number,index,"
            + "city_id) VALUES (?,?,?,?,?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE adress SET street=?, house_number=?,apartment_number=?,index=?,"
            + "city_id=? WHERE id=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM adress WHERE id=?";
  }

  @Override
  public Address recordEntity(final ResultSet resultSet) throws SQLException {
    return (Address) new Transformer<>(Address.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Address entity)
          throws SQLException {
    preparedStatement.setString(1, entity.getStreet());
    preparedStatement.setInt(2, entity.getHouseNumber());
    preparedStatement.setInt(3, entity.getApartmentNumber());
    preparedStatement.setInt(4, entity.getIndex());
    preparedStatement.setInt(5, entity.getCityId());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Address entity)
          throws SQLException {
    preparedStatement.setInt(6, entity.getId());
    return preparedStatement;
  }
}
