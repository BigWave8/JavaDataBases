package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.UserDAO;
import com.oryshchak.businesslogic.model.User;
import com.oryshchak.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOimpl implements UserDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM user";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM user WHERE user.id = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT user(phone_number,adress_id,name_id,password_id) VALUES (?,?,?,?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE user SET phone_number=?,adress_id=?,"
            + "name_id=?,password_id=? WHERE id=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM user WHERE id=?";
  }

  @Override
  public User recordEntity(final ResultSet resultSet) throws SQLException {
    return (User) new Transformer<>(User.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, User entity)
          throws SQLException {
    preparedStatement.setString(1, entity.getPhoneNumber());
    preparedStatement.setInt(2, entity.getAddressId());
    preparedStatement.setInt(3, entity.getNameId());
    preparedStatement.setInt(4, entity.getPasswordId());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, User entity)
          throws SQLException {
    preparedStatement.setInt(5, entity.getId());
    return preparedStatement;
  }
}
