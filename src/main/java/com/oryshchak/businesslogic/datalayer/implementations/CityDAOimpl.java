package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.CityDAO;
import com.oryshchak.businesslogic.model.City;
import com.oryshchak.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAOimpl implements CityDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM city";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM city WHERE city.id = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT city(city,region_id) VALUES (?,?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE city SET city=?, region_id=? WHERE id=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM city WHERE id=?";
  }

  @Override
  public City recordEntity(final ResultSet resultSet) throws SQLException {
    return (City) new Transformer<>(City.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, City entity)
          throws SQLException {
    preparedStatement.setString(1, entity.getCity());
    preparedStatement.setInt(2, entity.getRegionId());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, City entity)
          throws SQLException {
    preparedStatement.setInt(3, entity.getId());
    return preparedStatement;
  }
}
