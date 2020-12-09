package com.oryshchak.businesslogic.datalayer.implementations;

import com.oryshchak.businesslogic.datalayer.ParcelDAO;
import com.oryshchak.businesslogic.model.Parcel;
import com.oryshchak.businesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParcelDAOimpl implements ParcelDAO {

  @Override
  public String getFindAll() {
    return "SELECT * FROM parcel";
  }

  @Override
  public String getFindOfElement() {
    return "SELECT * FROM parcel WHERE parcel.order_number = ?";
  }

  @Override
  public String getCreate() {
    return "INSERT parcel(category,mass_in_kilogram,fragility,date_of_receiving,"
            + "sender,recepient,sender_id_department,recepient_id_department,"
            + "parcel_on_way_route_number,order_number) VALUES (?,?,?,?,?,?,?,?,?,?)";
  }

  @Override
  public String getUpdate() {
    return "UPDATE parcel SET category=?,mass_in_kilogram=?,fragility=?,date_of_receiving=?,"
            + "sender=?,recepient=?,sender_id_department=?,recepient_id_department=?,"
            + "parcel_on_way_route_number=? WHERE order_number=?";
  }

  @Override
  public String getRemove() {
    return "DELETE FROM parcel WHERE order_number=?";
  }

  @Override
  public Parcel recordEntity(final ResultSet resultSet) throws SQLException {
    return (Parcel) new Transformer<>(Parcel.class).extractDataToModel(resultSet);
  }

  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Parcel entity)
          throws SQLException {
    preparedStatement.setString(1, entity.getCategory());
    preparedStatement.setBigDecimal(2, entity.getMassInKilogram());
    preparedStatement.setBoolean(3, entity.getFragility());
    preparedStatement.setString(4, entity.getDateOfReceiving());
    preparedStatement.setInt(5, entity.getSender());
    preparedStatement.setInt(6, entity.getRecepient());
    preparedStatement.setInt(7, entity.getSenderIdDepartment());
    preparedStatement.setInt(8, entity.getRecepientIdDepartment());
    preparedStatement.setInt(9, entity.getParcelOnWayRouteNumber());
    preparedStatement.setString(10, entity.getOrderNumber());
    return preparedStatement;
  }

  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Parcel entity) {
    return preparedStatement;
  }
}