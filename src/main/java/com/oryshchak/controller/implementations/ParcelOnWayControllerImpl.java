package com.oryshchak.controller.implementations;

import com.oryshchak.business.GeneralService;
import com.oryshchak.business.implementations.CourierServiceImpl;
import com.oryshchak.business.implementations.ParcelOnWayServiceImpl;
import com.oryshchak.controller.ParcelOnWayController;
import com.oryshchak.model.ParcelOnWay;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ParcelOnWayControllerImpl implements ParcelOnWayController {

  private final Scanner input;

  public ParcelOnWayControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public GeneralService<ParcelOnWay, Integer> getService() {
    return new ParcelOnWayServiceImpl();
  }

  @Override
  public void printHeaders() {
    ParcelOnWay.printHeaders();
  }

  @Override
  public ParcelOnWay inputEntity() throws SQLException {
    ParcelOnWay parcelOnWay = new ParcelOnWay();

    System.out.println("Please write courier id:");
    final int inputCourierByCourierId = input.nextInt();
    parcelOnWay.setCourierByCourierId(new CourierServiceImpl().findById(inputCourierByCourierId));

    return parcelOnWay;
  }

  @Override
  public ParcelOnWay inputCreateEntity() throws SQLException, IOException {
    ParcelOnWay parcelOnWay = inputEntity();

    System.out.println("Please write id:");
    parcelOnWay.setId(input.nextInt());

    return parcelOnWay;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of Parcel On Way:");
    return input.nextInt();
  }
}
