package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.CourierDAO;
import com.oryshchak.businesslogic.model.Courier;
import com.oryshchak.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourierDAOimpl implements CourierDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM courier";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM courier WHERE courier.id = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT courier(name_id) VALUES (?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE courier SET name_id=? WHERE id=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM courier WHERE id=?";
  }

  @Override
  public Courier recordEntity(final ResultSet resultSet) throws SQLException {
    return (Courier) new Transformer<>(Courier.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Courier entity)
          throws SQLException {
    preparedStatement.setInt(1, entity.getNameId());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Courier entity)
          throws SQLException {
    preparedStatement.setInt(2, entity.getId());
    return preparedStatement;
  }
}
