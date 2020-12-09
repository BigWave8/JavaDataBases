package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.ParcelOnWayDAO;
import com.oryshchak.businesslogic.model.ParcelOnWay;
import com.oryshchak.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParcelOnWayDAOimpl implements ParcelOnWayDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM parcel_on_way";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM parcel_on_way WHERE parcel_on_way.id = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT parcel_on_way(courier_id) VALUES (?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE parcel_on_way SET courier_id=? WHERE id=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM parcel_on_way WHERE id=?";
  }

  @Override
  public ParcelOnWay recordEntity(final ResultSet resultSet) throws SQLException {
    return (ParcelOnWay) new Transformer<>(ParcelOnWay.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, ParcelOnWay entity)
          throws SQLException {
    preparedStatement.setInt(1, entity.getCourierId());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, ParcelOnWay entity)
          throws SQLException {
    preparedStatement.setInt(2, entity.getId());
    return preparedStatement;
  }
}
