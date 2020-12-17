package com.oryshchak.controller.implementations;

import com.oryshchak.business.GeneralService;
import com.oryshchak.business.implementations.AdressServiceImpl;
import com.oryshchak.business.implementations.NameServiceImpl;
import com.oryshchak.business.implementations.UserServiceImpl;
import com.oryshchak.controller.UserController;
import com.oryshchak.model.ParcelOnWay;
import com.oryshchak.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserControllerImpl implements UserController {

  private final Scanner input;

  public UserControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public GeneralService<User, Integer> getService() {
    return new UserServiceImpl();
  }

  @Override
  public void printHeaders() {
    User.printHeaders();
  }

  @Override
  public User inputEntity() throws SQLException {
    User user = new User();

    System.out.println("Please write phone number:");
    user.setPhoneNumber(input.nextLine());

    System.out.println("Please write adress id:");
    final int inputAdressByAdressId = input.nextInt();
    user.setAdressByAdressId(new AdressServiceImpl().findById(inputAdressByAdressId));

    System.out.println("Please write name id:");
    final int inputNameByNameId = input.nextInt();
    user.setNameByNameId(new NameServiceImpl().findById(inputNameByNameId));

    return user;
  }

  @Override
  public User inputCreateEntity() throws SQLException, IOException {
    User user = inputEntity();

    System.out.println("Please write id:");
    user.setId(input.nextInt());

    return user;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of User:");
    return input.nextInt();
  }
}
