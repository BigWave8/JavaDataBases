package com.oryshchak.controller.implementations;

import com.oryshchak.business.GeneralService;
import com.oryshchak.business.implementations.CourierServiceImpl;
import com.oryshchak.business.implementations.NameServiceImpl;
import com.oryshchak.controller.CourierController;
import com.oryshchak.model.Courier;
import java.sql.SQLException;
import java.util.Scanner;

public class CourierControllerImpl implements CourierController {

  private final Scanner input;

  public CourierControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public GeneralService<Courier, Integer> getService() {
    return new CourierServiceImpl();
  }

  @Override
  public void printHeaders() {
    Courier.printHeaders();
  }

  @Override
  public Courier inputEntity() throws SQLException {
    Courier courier = new Courier();

    System.out.println("Please write name id:");
    final int inputNameByNameId = input.nextInt();
    courier.setNameByNameId(new NameServiceImpl().findById(inputNameByNameId));

    return courier;
  }

  @Override
  public Courier inputCreateEntity() throws SQLException {
    Courier courier = inputEntity();

    System.out.println("Please write id:");
    courier.setId(input.nextInt());

    return courier;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of Courier:");
    return input.nextInt();
  }
}
