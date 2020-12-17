package com.oryshchak.controller.implementations;

import com.oryshchak.business.GeneralService;
import com.oryshchak.business.implementations.*;
import com.oryshchak.controller.ParcelController;
import com.oryshchak.model.Parcel;
import com.oryshchak.model.Region;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ParcelControllerImpl implements ParcelController {

  private final Scanner input;

  public ParcelControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public GeneralService<Parcel, String> getService() {
    return new ParcelServiceImpl();
  }

  @Override
  public void printHeaders() {
    Parcel.printHeaders();
  }

  @Override
  public Parcel inputEntity() throws SQLException {
    Parcel parcel = new Parcel();

    System.out.println("Please write category:");
    parcel.setCategory(input.nextLine());

    System.out.println("Please write mass in kilogram:");
    parcel.setMassInKilogram(input.nextBigDecimal());

    System.out.println("Please write fragility:");
    parcel.setFragility(input.nextByte());

    System.out.println("Please write date of receiving:");
    parcel.setDateOfReceiving(input.nextLine());

    System.out.println("Please write user by sender id user:");
    final int inputUserBySenderIdUser = input.nextInt();
    parcel.setUserBySenderIdUser(new UserServiceImpl().findById(inputUserBySenderIdUser));

    System.out.println("Please write user by recepient id user:");
    final int inputUserByRecepientIdUser = input.nextInt();
    parcel.setUserByRecepientIdUser(new UserServiceImpl().findById(inputUserByRecepientIdUser));

    System.out.println("Please write department by sender id department:");
    final int inputDepartmentBySenderIdDepartment = input.nextInt();
    parcel.setDepartmentBySenderIdDepartment(new DepartmentServiceImpl()
            .findById(inputDepartmentBySenderIdDepartment));

    System.out.println("Please write department by recepient id department:");
    final int inputDepartmentByRecepientIdDepartment = input.nextInt();
    parcel.setDepartmentByRecepientIdDepartment(new DepartmentServiceImpl()
            .findById(inputDepartmentByRecepientIdDepartment));

    System.out.println("Please write parcel on way by recepient id parcel on way:");
    final int inputParcelOnWayByRecepientIdParcelOnWay = input.nextInt();
    parcel.setParcelOnWayByRecepientIdParcelOnWay(new ParcelOnWayServiceImpl()
            .findById(inputParcelOnWayByRecepientIdParcelOnWay));

    return parcel;
  }

  @Override
  public Parcel inputCreateEntity() throws SQLException{
    Parcel parcel = inputEntity();

    System.out.println("Please write order number:");
    parcel.setOrderNumber(input.nextLine());

    return parcel;
  }

  @Override
  public String getId() {
    System.out.println("\nPlease write order number of Parcel:");
    return input.nextLine();
  }
}
