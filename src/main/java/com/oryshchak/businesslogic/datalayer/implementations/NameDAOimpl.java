package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.NameDAO;
import com.oryshchak.businesslogic.model.Name;
import com.oryshchak.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NameDAOimpl implements NameDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM name";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM name WHERE name.id = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT name(name,surname,middle_name,index) VALUES (?,?,?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE name SET name=?, surname=?, middle_name=?, index=? WHERE id=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM name WHERE id=?";
  }

  @Override
  public Name recordEntity(final ResultSet resultSet) throws SQLException {
    return (Name) new Transformer<>(Name.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Name entity)
          throws SQLException {
    preparedStatement.setString(1, entity.getName());
    preparedStatement.setString(2, entity.getSurname());
    preparedStatement.setString(3, entity.getMiddleName());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Name entity)
          throws SQLException {
    preparedStatement.setInt(4, entity.getId());
    return preparedStatement;
  }
}
