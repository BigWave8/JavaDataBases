package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.RegionDAO;
import com.oryshchak.businesslogic.model.Region;
import com.oryshchak.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionDAOimpl implements RegionDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM region";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM region WHERE region.id = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT region(region) VALUES (?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE region SET region=? WHERE id=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM region WHERE id=?";
  }

  @Override
  public Region recordEntity(final ResultSet resultSet) throws SQLException {
    return (Region) new Transformer<>(Region.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Region entity)
          throws SQLException {
    preparedStatement.setString(1, entity.getRegion());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Region entity)
          throws SQLException {
    preparedStatement.setInt(2, entity.getId());
    return preparedStatement;
  }
}
