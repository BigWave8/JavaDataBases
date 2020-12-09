package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.OperatorDAO;
import com.oryshchak.businesslogic.model.Operator;
import com.oryshchak.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperatorDAOimpl implements OperatorDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM operator";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM operator WHERE operator.id = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT operator(name_id) VALUES (?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE operator SET name_id=? WHERE id=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM operator WHERE id=?";
  }

  @Override
  public Operator recordEntity(final ResultSet resultSet) throws SQLException {
    return (Operator) new Transformer<>(Operator.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Operator entity)
          throws SQLException {
    preparedStatement.setInt(1, entity.getNameId());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Operator entity)
          throws SQLException {
    preparedStatement.setInt(2, entity.getId());
    return preparedStatement;
  }
}
