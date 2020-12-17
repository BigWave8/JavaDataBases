package com.oryshchak.controller.implementations;

import com.oryshchak.business.GeneralService;
import com.oryshchak.business.implementations.NameServiceImpl;
import com.oryshchak.controller.NameController;
import com.oryshchak.model.Name;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class NameControllerImpl implements NameController {

  private final Scanner input;

  public NameControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public GeneralService<Name, Integer> getService() {
    return new NameServiceImpl();
  }

  @Override
  public void printHeaders() {
    Name.printHeaders();
  }

  @Override
  public Name inputEntity() throws SQLException {
    Name name = new Name();

    System.out.println("Please write name:");
    name.setName(input.nextLine());

    System.out.println("Please write surname:");
    name.setSurname(input.nextLine());

    System.out.println("Please write middle name:");
    name.setMiddleName(input.nextLine());

    return name;
  }

  @Override
  public Name inputCreateEntity() throws SQLException, IOException {
    Name name = inputEntity();

    System.out.println("Please write id:");
    name.setId(input.nextInt());

    return name;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of Name:");
    return input.nextInt();
  }
}
