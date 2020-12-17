package com.oryshchak.controller.implementations;

import com.oryshchak.business.GeneralService;
import com.oryshchak.business.implementations.NameServiceImpl;
import com.oryshchak.business.implementations.OperatorServiceImpl;
import com.oryshchak.controller.OperatorController;
import com.oryshchak.model.Operator;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class OperatorControllerImpl implements OperatorController {

  private final Scanner input;

  public OperatorControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public GeneralService<Operator, Integer> getService() {
    return new OperatorServiceImpl();
  }

  @Override
  public void printHeaders() {
    Operator.printHeaders();
  }

  @Override
  public Operator inputEntity() throws SQLException {
    Operator operator = new Operator();

    System.out.println("Please write name id:");
    final int inputNameByNameId = input.nextInt();
    operator.setNameByNameId(new NameServiceImpl().findById(inputNameByNameId));

    return operator;
  }

  @Override
  public Operator inputCreateEntity() throws SQLException {
    Operator operator = inputEntity();

    System.out.println("Please write id:");
    operator.setId(input.nextInt());

    return operator;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of Operator:");
    return input.nextInt();
  }
}
