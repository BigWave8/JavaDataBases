package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.PasswordDAO;
import com.oryshchak.businesslogic.model.Password;
import com.oryshchak.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordDAOimpl implements PasswordDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM password";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM password WHERE password.id = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT password(password) VALUES (?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE password SET password=? WHERE id=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM password WHERE id=?";
  }

  @Override
  public Password recordEntity(final ResultSet resultSet) throws SQLException {
    return (Password) new Transformer<>(Password.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Password entity)
          throws SQLException {
    preparedStatement.setString(1, entity.getPassword());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Password entity)
          throws SQLException {
    preparedStatement.setInt(2, entity.getId());
    return preparedStatement;
  }
}
