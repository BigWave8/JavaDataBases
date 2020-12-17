package com.oryshchak.view;

import com.oryshchak.controller.*;
import com.oryshchak.controller.implementations.*;
import com.oryshchak.manager.SessionManager;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class View {

  private final Map<String, String> menu;
  private final Map<String, Printable> methodsMenu;
  private final Scanner input;

  private final AdressController adressController;
  private final CityController cityController;
  private final CourierController courierController;
  private final DepartmentController departmentController;
  private final NameController nameController;
  private final OperatorController operatorController;
  private final ParcelController parcelController;
  private final ParcelOnWayController parcelOnWayController;
  private final RegionController regionController;
  private final UserController userController;

  public View() {

    input = new Scanner(System.in, StandardCharsets.UTF_8);

    adressController = new AdressControllerImpl(input);
    cityController = new CityControllerImpl(input);
    courierController = new CourierControllerImpl(input);
    departmentController = new DepartmentControllerImpl(input);
    nameController = new NameControllerImpl(input);
    operatorController = new OperatorControllerImpl(input);
    parcelController = new ParcelControllerImpl(input);
    parcelOnWayController = new ParcelOnWayControllerImpl(input);
    regionController = new RegionControllerImpl(input);
    userController = new UserControllerImpl(input);

    menu = new LinkedHashMap<>();
    methodsMenu = new LinkedHashMap<>();

    menu.put("A", "A-Select all table");

    methodsMenu.put("A", this::printAllTables);

    //Adress Menu
    menu.put("0", "0-Table: Adress");
    menu.put("01", "01-Find all adresses");
    menu.put("02", "02-Find adress by id");
    menu.put("03", "03-Create adress");
    menu.put("04", "04-Update adress");
    menu.put("05", "05-Delete adress");

    methodsMenu.put("01", adressController::getEntities);
    methodsMenu.put("02", adressController::getEntity);
    methodsMenu.put("03", adressController::setEntity);
    methodsMenu.put("04", adressController::putEntity);
    methodsMenu.put("05", adressController::removeEntity);

    //City Menu
    menu.put("1", "1-Table: City");
    menu.put("11", "11-Find all cities");
    menu.put("12", "12-Find city by id");
    menu.put("13", "13-Create city");
    menu.put("14", "14-Update city");
    menu.put("15", "15-Delete city");

    methodsMenu.put("11", cityController::getEntities);
    methodsMenu.put("12", cityController::getEntity);
    methodsMenu.put("13", cityController::setEntity);
    methodsMenu.put("14", cityController::putEntity);
    methodsMenu.put("15", cityController::removeEntity);

    //Courier Menu
    menu.put("2", "2-Table: Courier");
    menu.put("21", "21-Find all couriers");
    menu.put("22", "22-Find courier by id");
    menu.put("23", "23-Create courier");
    menu.put("24", "24-Update courier");
    menu.put("25", "25-Delete courier");

    methodsMenu.put("21", courierController::getEntities);
    methodsMenu.put("22", courierController::getEntity);
    methodsMenu.put("23", courierController::setEntity);
    methodsMenu.put("24", courierController::putEntity);
    methodsMenu.put("25", courierController::removeEntity);

    //Department Menu
    menu.put("3", "3-Table: Department");
    menu.put("31", "31-Find all departments");
    menu.put("32", "32-Find department by id");
    menu.put("33", "33-Create department");
    menu.put("34", "34-Update department");
    menu.put("35", "35-Delete department");

    methodsMenu.put("31", departmentController::getEntities);
    methodsMenu.put("32", departmentController::getEntity);
    methodsMenu.put("33", departmentController::setEntity);
    methodsMenu.put("34", departmentController::putEntity);
    methodsMenu.put("35", departmentController::removeEntity);

    //Name Menu
    menu.put("4", "4-Table: Name");
    menu.put("41", "41-Find all names");
    menu.put("42", "42-Find name by id");
    menu.put("43", "43-Create name");
    menu.put("44", "44-Update name");
    menu.put("45", "45-Delete name");

    methodsMenu.put("41", nameController::getEntities);
    methodsMenu.put("42", nameController::getEntity);
    methodsMenu.put("43", nameController::setEntity);
    methodsMenu.put("44", nameController::putEntity);
    methodsMenu.put("45", nameController::removeEntity);

    //Operator Menu
    menu.put("5", "5-Table: Operator");
    menu.put("51", "51-Find all operators");
    menu.put("52", "52-Find operator by id");
    menu.put("53", "53-Create operator");
    menu.put("54", "54-Update operator");
    menu.put("55", "55-Delete operator");

    methodsMenu.put("51", operatorController::getEntities);
    methodsMenu.put("52", operatorController::getEntity);
    methodsMenu.put("53", operatorController::setEntity);
    methodsMenu.put("54", operatorController::putEntity);
    methodsMenu.put("55", operatorController::removeEntity);

    //Parcel Menu
    menu.put("6", "6-Table: Parcel");
    menu.put("61", "61-Find all parcels");
    menu.put("62", "62-Find parcel by id");
    menu.put("63", "63-Create parcel");
    menu.put("64", "64-Update parcel");
    menu.put("65", "65-Delete parcel");

    methodsMenu.put("61", parcelController::getEntities);
    methodsMenu.put("62", parcelController::getEntity);
    methodsMenu.put("63", parcelController::setEntity);
    methodsMenu.put("64", parcelController::putEntity);
    methodsMenu.put("65", parcelController::removeEntity);

    //ParcelOnWay Menu
    menu.put("7", "7-Table: Parcel On Way");
    menu.put("71", "71-Find all parcel on ways");
    menu.put("72", "72-Find parcel on way by id");
    menu.put("73", "73-Create parcel on way");
    menu.put("74", "74-Update parcel on way");
    menu.put("75", "75-Delete parcel on way");

    methodsMenu.put("71", parcelOnWayController::getEntities);
    methodsMenu.put("72", parcelOnWayController::getEntity);
    methodsMenu.put("73", parcelOnWayController::setEntity);
    methodsMenu.put("74", parcelOnWayController::putEntity);
    methodsMenu.put("75", parcelOnWayController::removeEntity);

    //Region Menu
    menu.put("8", "8-Table: Region");
    menu.put("81", "81-Find all regions");
    menu.put("82", "82-Find region by id");
    menu.put("83", "83-Create region");
    menu.put("84", "84-Update region");
    menu.put("85", "85-Delete region");

    methodsMenu.put("81", regionController::getEntities);
    methodsMenu.put("82", regionController::getEntity);
    methodsMenu.put("83", regionController::setEntity);
    methodsMenu.put("84", regionController::putEntity);
    methodsMenu.put("85", regionController::removeEntity);

    //User Menu
    menu.put("9", "9-Table: User");
    menu.put("91", "91-Find all users");
    menu.put("92", "92-Find user by id");
    menu.put("93", "93-Create user");
    menu.put("94", "94-Update user");
    menu.put("95", "95-Delete user");

    methodsMenu.put("91", userController::getEntities);
    methodsMenu.put("92", userController::getEntity);
    methodsMenu.put("93", userController::setEntity);
    methodsMenu.put("94", userController::putEntity);
    methodsMenu.put("95", userController::removeEntity);

    menu.put("L", "L-go back");
    menu.put("Q", "Q-exit");
  }

  private void printAllTables() throws SQLException {
    adressController.getEntities();
    cityController.getEntities();
    courierController.getEntities();
    departmentController.getEntities();
    nameController.getEntities();
    operatorController.getEntities();
    parcelController.getEntities();
    parcelOnWayController.getEntities();
    regionController.getEntities();
    userController.getEntities();
  }

  public void show() {

    String keyMenu;

    do {
      printMenu();
      System.out.println("Please, select point:");
      keyMenu = input.nextLine().toUpperCase();
      while (keyMenu.equals("")) {
        keyMenu = input.nextLine().toUpperCase();
      }

      if (keyMenu.equals("L")) {
        continue;
      }
      if (keyMenu.equals("Q")) {
        SessionManager.closeSessionFactory();
        break;
      }

      if (keyMenu.matches("(^\\d)")) {
        printSubMenu(keyMenu);
        System.out.println("Please select point of menu:");
        keyMenu = input.nextLine().toUpperCase();
        while (keyMenu.equals("")) {
          keyMenu = input.nextLine().toUpperCase();
        }
      }

      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception throwables) {
        System.out.println("Can't execute command");
        System.out.println("Exception is " + throwables.getMessage());
      }
    } while (true);
  }

  private void printMenu() {
    System.out.print("\n\nMenu:\n");
    for (Map.Entry<String, String> item : menu.entrySet()) {
      if (item.getKey().length() == 1 && !item.getKey().equals("L")) {
        System.out.println(item.getValue());
      }
    }
  }

  private void printSubMenu(String fig) {
    System.out.println("\n\nSubMenu:\n");
    for (Map.Entry<String, String> item : menu.entrySet()) {
      if (item.getKey().length() != 1 && item.getKey().substring(0, 1).equals(fig)
              || item.getKey().equals("L") || item.getKey().equals("Q")) {
        System.out.println(item.getValue());
      }
    }
  }
}
