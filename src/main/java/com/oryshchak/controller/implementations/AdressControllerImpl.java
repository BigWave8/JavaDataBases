package com.oryshchak.controller.implementations;

import com.oryshchak.business.GeneralService;
import com.oryshchak.business.implementations.AdressServiceImpl;
import com.oryshchak.business.implementations.CityServiceImpl;
import com.oryshchak.controller.AdressController;
import com.oryshchak.model.Adress;
import java.sql.SQLException;
import java.util.Scanner;

public class AdressControllerImpl implements AdressController {

  private final Scanner input;

  public AdressControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public GeneralService<Adress, Integer> getService() {
    return new AdressServiceImpl();
  }

  @Override
  public void printHeaders() {
    Adress.printHeaders();
  }

  @Override
  public Adress inputEntity() throws SQLException {
    Adress adress = new Adress();

    System.out.println("Please write street:");
    adress.setStreet(input.nextLine());

    System.out.println("Please write house number:");
    adress.setHouseNumber(input.nextLine());

    System.out.println("Please write apartment number:");
    adress.setApartmentNumber(input.nextLine());

    System.out.println("Please write index:");
    adress.setIndex(input.nextLine());

    System.out.println("Please write city id:");
    final int inputCityByCityId = input.nextInt();
    adress.setCityByCityId(new CityServiceImpl().findById(inputCityByCityId));

    return adress;
  }

  @Override
  public Adress inputCreateEntity() throws SQLException {
    Adress adress = inputEntity();

    System.out.println("Please write id:");
    adress.setId(input.nextInt());

    return adress;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of Adress:");
    return input.nextInt();
  }
}