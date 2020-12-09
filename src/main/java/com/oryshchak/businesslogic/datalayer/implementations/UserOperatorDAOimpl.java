package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.UserOperatorDAO;
import com.oryshchak.businesslogic.model.UserOperator;
import com.oryshchak.businesslogic.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOperatorDAOimpl implements UserOperatorDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM user_operator";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM user_operator WHERE user_operator.id = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT user_operator(user_id,operator_id) VALUES (?,?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE user_operator SET user_id=?, operator_id=? WHERE id=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM user_operator WHERE id=?";
  }

  @Override
  public UserOperator recordEntity(final ResultSet resultSet) throws SQLException {
    return (UserOperator) new Transformer<>(UserOperator.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, UserOperator entity)
          throws SQLException {
    preparedStatement.setInt(1, entity.getUserId());
    preparedStatement.setInt(2, entity.getOperatorId());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, UserOperator entity)
          throws SQLException {
    preparedStatement.setInt(3, entity.getId());
    return preparedStatement;
  }
}
