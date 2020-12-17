package com.oryshchak.controller.implementations;

import com.oryshchak.business.GeneralService;
import com.oryshchak.business.implementations.CityServiceImpl;
import com.oryshchak.business.implementations.RegionServiceImpl;
import com.oryshchak.controller.CityController;
import com.oryshchak.model.City;
import java.sql.SQLException;
import java.util.Scanner;

public class CityControllerImpl implements CityController {

  private final Scanner input;

  public CityControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public GeneralService<City, Integer> getService() {
    return new CityServiceImpl();
  }

  @Override
  public void printHeaders() {
    City.printHeaders();
  }

  @Override
  public City inputEntity() throws SQLException {
    City city = new City();

    System.out.println("Please write city:");
    city.setCity(input.nextLine());

    System.out.println("Please write region id:");
    final int inputRegionByRegionId = input.nextInt();
    city.setRegionByRegionId(new RegionServiceImpl().findById(inputRegionByRegionId));

    return city;
  }

  @Override
  public City inputCreateEntity() throws SQLException{
    City city = inputEntity();

    System.out.println("Please write id:");
    city.setId(input.nextInt());

    return city;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of City:");
    return input.nextInt();
  }
}