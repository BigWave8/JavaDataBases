package com.oryshchak.controller.implementations;

import com.oryshchak.business.GeneralService;
import com.oryshchak.business.implementations.AdressServiceImpl;
import com.oryshchak.business.implementations.DepartmentServiceImpl;
import com.oryshchak.controller.DepartmentController;
import com.oryshchak.model.Courier;
import com.oryshchak.model.Department;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class DepartmentControllerImpl implements DepartmentController {

  private final Scanner input;

  public DepartmentControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public GeneralService<Department, Integer> getService() {
    return new DepartmentServiceImpl();
  }

  @Override
  public void printHeaders() {
    Department.printHeaders();
  }

  @Override
  public Department inputEntity() throws SQLException {
    Department department = new Department();

    System.out.println("Please write index:");
    department.setIndex(input.nextInt());

    System.out.println("Please write adress id:");
    final int inputAdressByAdressId = input.nextInt();
    department.setAdressByAdressId(new AdressServiceImpl().findById(inputAdressByAdressId));

    return department;
  }

  @Override
  public Department inputCreateEntity() throws SQLException {
    Department department = inputEntity();

    System.out.println("Please write id:");
    department.setId(input.nextInt());

    return department;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of Department:");
    return input.nextInt();
  }
}
