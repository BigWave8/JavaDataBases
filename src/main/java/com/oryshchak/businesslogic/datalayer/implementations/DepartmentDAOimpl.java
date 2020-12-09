package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.DepartmentDAO;
import com.oryshchak.businesslogic.model.Department;
import com.oryshchak.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAOimpl implements DepartmentDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM department";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM department WHERE department.id = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT department(index, address_id) VALUES (?,?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE department SET name_id=?, address_id=? WHERE id=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM department WHERE id=?";
  }

  @Override
  public Department recordEntity(final ResultSet resultSet) throws SQLException {
    return (Department) new Transformer<>(Department.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Department entity)
          throws SQLException {
    preparedStatement.setInt(1, entity.getIndex());
    preparedStatement.setInt(2, entity.getAddressId());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Department entity)
          throws SQLException {
    preparedStatement.setInt(3, entity.getId());
    return preparedStatement;
  }
}
