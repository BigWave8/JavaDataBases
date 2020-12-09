package com.oryshchak.view;

import com.oryshchak.businesslogic.model.*;
import com.oryshchak.controller.*;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {

  private final Map<String, String> menu;
  private final Map<String, Printable> methodsMenu;
  private final Scanner input;

  private final AddressController addressController;
  private final CityController cityController;
  private final CourierController courierController;
  private final DepartmentController departmentController;
  private final NameController nameController;
  private final OperatorController operatorController;
  private final ParcelController parcelController;
  private final ParcelOnWayController parcelOnWayController;
  private final PasswordController passwordController;
  private final RegionController regionController;
  private final UserController userController;
  private final UserOperatorController userOperatorController;

  public View() {
    input = new Scanner(System.in, StandardCharsets.UTF_8);

    addressController = new AddressController();
    cityController = new CityController();
    courierController = new CourierController();
    departmentController = new DepartmentController();
    nameController = new NameController();
    operatorController = new OperatorController();
    parcelController = new ParcelController();
    parcelOnWayController = new ParcelOnWayController();
    passwordController = new PasswordController();
    regionController = new RegionController();
    userController = new UserController();
    userOperatorController = new UserOperatorController();

    menu = new LinkedHashMap<>();
    methodsMenu = new LinkedHashMap<>();

    menu.put("A", "A-Select all table");

    methodsMenu.put("A", this::printAllTables);

    //Address Menu
    menu.put("1", "1-Table:  Address");
    menu.put("11", "11-Find all addresses");
    menu.put("12", "12-Find address by id");
    menu.put("13", "13-Create address");
    menu.put("14", "14-Update address");
    menu.put("15", "15-Delete address");

    methodsMenu.put("11", this::printAddressTable);
    methodsMenu.put("12", this::printRowFromAddressById);
    methodsMenu.put("13", this::createNewAddress);
    methodsMenu.put("14", this::updateAddress);
    methodsMenu.put("15", this::deleteAddress);

    //City Menu
    menu.put("2", "2-Table:  City");
    menu.put("21", "21-Find all cities");
    menu.put("22", "22-Find city by id");
    menu.put("23", "23-Create city");
    menu.put("24", "24-Update city");
    menu.put("25", "25-Delete city");

    methodsMenu.put("21", this::printCityTable);
    methodsMenu.put("22", this::printRowFromCityById);
    methodsMenu.put("23", this::createNewCity);
    methodsMenu.put("24", this::updateCity);
    methodsMenu.put("25", this::deleteCity);

    //Courier Menu
    menu.put("3", "3-Table:  Courier");
    menu.put("31", "31-Find all couriers");
    menu.put("32", "32-Find courier by id");
    menu.put("33", "33-Create courier");
    menu.put("34", "34-Update courier");
    menu.put("35", "35-Delete courier");

    methodsMenu.put("31", this::printCourierTable);
    methodsMenu.put("32", this::printRowFromCourierById);
    methodsMenu.put("33", this::createNewCourier);
    methodsMenu.put("34", this::updateCourier);
    methodsMenu.put("35", this::deleteCourier);

    //Department Menu
    menu.put("4", "4-Table:  Department");
    menu.put("41", "41-Find all departments");
    menu.put("42", "42-Find department by id");
    menu.put("43", "43-Create department");
    menu.put("44", "44-Update department");
    menu.put("45", "45-Delete department");

    methodsMenu.put("41", this::printDepartmentTable);
    methodsMenu.put("42", this::printRowFromDepartmentById);
    methodsMenu.put("43", this::createNewDepartment);
    methodsMenu.put("44", this::updateDepartment);
    methodsMenu.put("45", this::deleteDepartment);

    //Name Menu
    menu.put("5", "5-Table:  Name");
    menu.put("51", "51-Find all names");
    menu.put("52", "52-Find name by id");
    menu.put("53", "53-Create name");
    menu.put("54", "54-Update name");
    menu.put("55", "55-Delete name");

    methodsMenu.put("51", this::printNameTable);
    methodsMenu.put("52", this::printRowFromNameById);
    methodsMenu.put("53", this::createNewName);
    methodsMenu.put("54", this::updateName);
    methodsMenu.put("55", this::deleteName);

    //Operator Menu
    menu.put("6", "6-Table:  Operator");
    menu.put("61", "61-Find all operators");
    menu.put("62", "62-Find operator by id");
    menu.put("63", "63-Create operator");
    menu.put("64", "64-Update operator");
    menu.put("65", "65-Delete operator");

    methodsMenu.put("61", this::printOperatorTable);
    methodsMenu.put("62", this::printRowFromOperatorById);
    methodsMenu.put("63", this::createNewOperator);
    methodsMenu.put("64", this::updateOperator);
    methodsMenu.put("65", this::deleteOperator);

    //Parcel Menu
    menu.put("7", "7-Table:  Parcel");
    menu.put("71", "71-Find all parcels");
    menu.put("72", "72-Find parcel by id");
    menu.put("73", "73-Create parcel");
    menu.put("74", "74-Update parcel");
    menu.put("75", "75-Delete parcel");

    methodsMenu.put("71", this::printParcelTable);
    methodsMenu.put("72", this::printRowFromParcelById);
    methodsMenu.put("73", this::createNewParcel);
    methodsMenu.put("74", this::updateParcel);
    methodsMenu.put("75", this::deleteParcel);

    //ParcelOnWay Menu
    menu.put("8", "8-Table:  Parcel On Way");
    menu.put("81", "81-Find all parcels on way");
    menu.put("82", "82-Find parcel on way by id");
    menu.put("83", "83-Create parcel on way");
    menu.put("84", "84-Update parcel on way");
    menu.put("85", "85-Delete parcel on way");

    methodsMenu.put("81", this::printParcelOnWayTable);
    methodsMenu.put("82", this::printRowFromParcelOnWayById);
    methodsMenu.put("83", this::createNewParcelOnWay);
    methodsMenu.put("84", this::updateParcelOnWay);
    methodsMenu.put("85", this::deleteParcelOnWay);

    //Password Menu
    menu.put("9", "9-Table:  Password");
    menu.put("91", "91-Find all passwords");
    menu.put("92", "92-Find password by id");
    menu.put("93", "93-Create password");
    menu.put("94", "94-Update password");
    menu.put("95", "95-Delete password");

    methodsMenu.put("91", this::printPasswordTable);
    methodsMenu.put("92", this::printRowFromPasswordById);
    methodsMenu.put("93", this::createNewPassword);
    methodsMenu.put("94", this::updatePassword);
    methodsMenu.put("95", this::deletePassword);

    //Region Menu
    menu.put("X", "X-Table:  Region");
    menu.put("X1", "X1-Find all regions");
    menu.put("X2", "X2-Find region by id");
    menu.put("X3", "X3-Create region");
    menu.put("X4", "X4-Update region");
    menu.put("X5", "X5-Delete region");

    methodsMenu.put("X1", this::printRegionTable);
    methodsMenu.put("X2", this::printRowFromRegionById);
    methodsMenu.put("X3", this::createNewRegion);
    methodsMenu.put("X4", this::updateRegion);
    methodsMenu.put("X5", this::deleteRegion);

    //User Menu
    menu.put("Y", "Y-Table:  User");
    menu.put("Y1", "Y1-Find all users");
    menu.put("Y2", "Y2-Find user by id");
    menu.put("Y3", "Y3-Create user");
    menu.put("Y4", "Y4-Update user");
    menu.put("Y5", "Y5-Delete user");

    methodsMenu.put("Y1", this::printUserTable);
    methodsMenu.put("Y2", this::printRowFromUserById);
    methodsMenu.put("Y3", this::createNewUser);
    methodsMenu.put("Y4", this::updateUser);
    methodsMenu.put("Y5", this::deleteUser);

    //UserOperator Menu
    menu.put("Z", "Z-Table:  User-Operator");
    menu.put("Z1", "Z1-Find all user-operator");
    menu.put("Z2", "Z2-Find user-operator by id");
    menu.put("Z3", "Z3-Create user-operator");
    menu.put("Z4", "Z4-Update user-operator");
    menu.put("Z5", "Z5-Delete user-operator");

    methodsMenu.put("Z1", this::printUserOperatorTable);
    methodsMenu.put("Z2", this::printRowFromUserOperatorById);
    methodsMenu.put("Z3", this::createNewUserOperator);
    methodsMenu.put("Z4", this::updateUserOperator);
    methodsMenu.put("Z5", this::deleteUserOperator);

    menu.put("L", "L-go back");
    menu.put("Q", "Q-exit");
  }

  public void show() {

    String keyMenu;

    while (true) {
      printMenu();
      System.out.println("Select point:");
      keyMenu = input.nextLine().toUpperCase();
      while (keyMenu.equals("")) {
        keyMenu = input.nextLine().toUpperCase();
      }

      if (keyMenu.equals("L")) {
        continue;
      }
      if (keyMenu.equals("Q")) {
        break;
      }

      if (keyMenu.matches("(^\\d)|^[XYZ]")) {
        printSubMenu(keyMenu);
        System.out.println("Select point of menu:");
        keyMenu = input.nextLine().toUpperCase();
        while (keyMenu.equals("")) {
          keyMenu = input.nextLine().toUpperCase();
        }
      }

      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception throwables) {
        System.out.println("Can't execute command");
        System.out.println("Expresion is " + throwables.getMessage());
      }
    }
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
      if (item.getValue().length() != 1 && item.getValue().substring(0, 1).equals(fig)
              || item.getKey().equals("L") || item.getKey().equals("Q")) {
        System.out.println(item.getValue());
      }
    }
  }

  private Address readAddress() {
    System.out.println("Please write street:");
    final String inputStreet = input.nextLine();

    System.out.println("Please write house number:");
    final Integer inputHouseNumber = input.nextInt();

    System.out.println("Please write apartment number:");
    final Integer inputApartmentNumber = input.nextInt();

    System.out.println("Please write index:");
    final Integer inputIndex = input.nextInt();

    System.out.println("Please write citi id:");
    final Integer inputCityId = input.nextInt();

    return new Address(0, inputStreet, inputHouseNumber,
            inputApartmentNumber, inputIndex, inputCityId);
  }

  private Integer readAddressId() {
    System.out.println("Please write id of Address:");
    return input.nextInt();
  }

  private void printAddressTable() throws SQLException {
    List<Address> addresses = addressController.getAddress();
    System.out.print("\n\nAddress\n");
    System.out.format("%3s   %-20s %-12s %-18s %-7s %-5s%n", "id", "street", "houseNumber",
            "apartmentNumber", "index", "cityId");
    for (Address address : addresses) {
      System.out.println(address);
    }
  }

  private void printRowFromAddressById() throws SQLException {
    int inputId = readAddressId();
    System.out.print("\n\nAddress\n");
    System.out.format("%3s   %-20s %-12s %-18s %-7s %-5s%n", "id", "street", "houseNumber",
            "apartmentNumber", "index", "cityId");
    System.out.println(addressController.getAddress(inputId));
  }

  private void createNewAddress() throws SQLException {
    Address address = readAddress();
    addressController.setAddress(address);
  }

  private void updateAddress() throws SQLException {
    Address address = readAddress();

    int inputId = readAddressId();
    address.setId(inputId);

    addressController.putAddress(address);
  }

  private void deleteAddress() throws SQLException {
    addressController.removeAddress(readAddressId());
  }


  private City readCity() {
    System.out.println("Please write city:");
    final String inputCity = input.nextLine();

    System.out.println("Please write region id:");
    final Integer inputRegionId = input.nextInt();

    return new City(0, inputCity, inputRegionId);
  }

  private Integer readCityId() {
    System.out.println("Please write id of City:");
    return input.nextInt();
  }

  private void printCityTable() throws SQLException {
    List<City> cities = cityController.getCity();
    System.out.print("\n\nCity\n");
    System.out.format("%3s   %-20s %-5s%n", "id", "city", "regionId");
    for (City city : cities) {
      System.out.println(city);
    }
  }

  private void printRowFromCityById() throws SQLException {
    int inputId = readCityId();
    System.out.print("\n\nCity\n");
    System.out.format("%3s   %-20s %-5s%n", "id", "city", "regionId");
    System.out.println(cityController.getCity(inputId));
  }

  private void createNewCity() throws SQLException {
    City city = readCity();
    cityController.setCity(city);
  }

  private void updateCity() throws SQLException {
    City city = readCity();

    int inputId = readCityId();
    city.setId(inputId);

    cityController.putCity(city);
  }

  private void deleteCity() throws SQLException {
    cityController.removeCity(readCityId());
  }


  private Courier readCourier() {
    System.out.println("Please write name id:");
    final Integer inputNameId = input.nextInt();

    return new Courier(0, inputNameId);
  }

  private Integer readCourierId() {
    System.out.println("Please write id of Courier:");
    return input.nextInt();
  }

  private void printCourierTable() throws SQLException {
    List<Courier> couriers = courierController.getCourier();
    System.out.print("\n\nCourier\n");
    System.out.format("%3s   %-7s%n", "id", "nameId");
    for (Courier courier : couriers) {
      System.out.println(courier);
    }
  }

  private void printRowFromCourierById() throws SQLException {
    int inputId = readCourierId();
    System.out.print("\n\nCourier\n");
    System.out.format("%3s   %-7s%n", "id", "nameId");
    System.out.println(courierController.getCourier(inputId));
  }

  private void createNewCourier() throws SQLException {
    Courier courier = readCourier();
    courierController.setCourier(courier);
  }

  private void updateCourier() throws SQLException {
    Courier courier = readCourier();

    int inputId = readCourierId();
    courier.setId(inputId);

    courierController.putCourier(courier);
  }

  private void deleteCourier() throws SQLException {
    courierController.removeCourier(readCourierId());
  }


  private Department readDepartment() {
    System.out.println("Please write index:");
    final Integer inputIndex = input.nextInt();

    System.out.println("Please write address id:");
    final Integer inputAddressId = input.nextInt();

    return new Department(0, inputIndex, inputAddressId);
  }

  private Integer readDepartmentId() {
    System.out.println("Please write id of Department:");
    return input.nextInt();
  }

  private void printDepartmentTable() throws SQLException {
    List<Department> departments = departmentController.getDepartment();
    System.out.print("\n\nDepartment\n");
    System.out.format("%3s   %-7s %-5s%n", "id", "index", "addressId");
    for (Department department : departments) {
      System.out.println(department);
    }
  }

  private void printRowFromDepartmentById() throws SQLException {
    int inputId = readDepartmentId();
    System.out.print("\n\nDepartment\n");
    System.out.format("%3s   %-7s %-5s%n", "id", "index", "addressId");
    System.out.println(departmentController.getDepartment(inputId));
  }

  private void createNewDepartment() throws SQLException {
    Department department = readDepartment();
    departmentController.setDepartment(department);
  }

  private void updateDepartment() throws SQLException {
    Department department = readDepartment();

    int inputId = readDepartmentId();
    department.setId(inputId);

    departmentController.putDepartment(department);
  }

  private void deleteDepartment() throws SQLException {
    departmentController.removeDepartment(readDepartmentId());
  }


  private Name readName() {
    System.out.println("Please write name:");
    final String inputName = input.nextLine();

    System.out.println("Please write surname:");
    final String inputSurname = input.nextLine();

    System.out.println("Please write middle name:");
    final String inputMiddleName = input.nextLine();

    return new Name(0, inputName, inputSurname, inputMiddleName);
  }

  private Integer readNameId() {
    System.out.println("Please write id of Name:");
    return input.nextInt();
  }

  private void printNameTable() throws SQLException {
    List<Name> names = nameController.getName();
    System.out.print("\n\nName\n");
    System.out.format("%3s   %-20s %-20s %-20s%n", "id", "name", "surname", "middleName");
    for (Name name : names) {
      System.out.println(name);
    }
  }

  private void printRowFromNameById() throws SQLException {
    int inputId = readNameId();
    System.out.print("\n\nName\n");
    System.out.format("%3s   %-20s %-20s %-20s%n", "id", "name", "surname", "middleName");
    System.out.println(nameController.getName(inputId));
  }

  private void createNewName() throws SQLException {
    Name name = readName();
    nameController.setName(name);
  }

  private void updateName() throws SQLException {
    Name name = readName();

    int inputId = readNameId();
    name.setId(inputId);

    nameController.putName(name);
  }

  private void deleteName() throws SQLException {
    nameController.removeName(readNameId());
  }


  private Operator readOperator() {
    System.out.println("Please write name id:");
    final Integer inputNameId = input.nextInt();

    return new Operator(0, inputNameId);
  }

  private Integer readOperatorId() {
    System.out.println("Please write id of Operator:");
    return input.nextInt();
  }

  private void printOperatorTable() throws SQLException {
    List<Operator> operators = operatorController.getOperator();
    System.out.print("\n\nOperator\n");
    System.out.format("%3s   %-7s%n", "id", "nameId");
    for (Operator operator : operators) {
      System.out.println(operator);
    }
  }

  private void printRowFromOperatorById() throws SQLException {
    int inputId = readOperatorId();
    System.out.print("\n\nOperator\n");
    System.out.format("%3s   %-7s%n", "id", "nameId");
    System.out.println(operatorController.getOperator(inputId));
  }

  private void createNewOperator() throws SQLException {
    Operator operator = readOperator();
    operatorController.setOperator(operator);
  }

  private void updateOperator() throws SQLException {
    Operator operator = readOperator();

    int inputId = readOperatorId();
    operator.setId(inputId);

    operatorController.putOperator(operator);
  }

  private void deleteOperator() throws SQLException {
    operatorController.removeOperator(readOperatorId());
  }


  private Parcel readParcel() {
    System.out.println("Please write order number:");
    final String inputOrderNumber = input.nextLine();

    System.out.println("Please write category:");
    final String inputCategory = input.nextLine();

    System.out.println("Please write mass in kilogram:");
    final BigDecimal inputMassInKilogram = input.nextBigDecimal();

    System.out.println("Please write fragility:");
    final Boolean inputFragility = input.nextBoolean();

    input.nextLine();
    System.out.println("Please write date of receiving:");
    final String inputDateOfReceiving = input.nextLine();

    System.out.println("Please write sender:");
    final Integer inputSender = input.nextInt();

    System.out.println("Please write recepient:");
    final Integer inputRecepient = input.nextInt();

    System.out.println("Please write sender id department:");
    final Integer inputSenderIdDepartment = input.nextInt();

    System.out.println("Please write recepient id department:");
    final Integer inputRecepientIdDepartment = input.nextInt();

    System.out.println("Please write parcel on way route number:");
    final Integer inputParcelOnWayRouteNumber = input.nextInt();

    return new Parcel(inputOrderNumber, inputCategory, inputMassInKilogram,
            inputFragility, inputDateOfReceiving, inputSender, inputRecepient,
            inputSenderIdDepartment, inputRecepientIdDepartment, inputParcelOnWayRouteNumber);
  }

  private String readParcelId() {
    input.nextLine();
    System.out.println("Please write order number of Parcel:");
    return input.nextLine();
  }

  private void printParcelTable() throws SQLException {
    List<Parcel> parcels = parcelController.getParcel();
    System.out.print("\n\nParcel\n");
    System.out.format("%20s   %-10s %-15s %-10s %-20s %-7s %-10s %-20s %-23s %-30s%n",
            "orderNumber", "category", "massInKilogram", "fragility", "dateOfReceiving",
            "sender", "recepient", "senderIdDepartment",
            "recepientIdDepartment", "parcelOnWayRouteNumber");
    for (Parcel parcel : parcels) {
      System.out.println(parcel);
    }
  }

  private void printRowFromParcelById() throws SQLException {
    String inputId = readParcelId();
    System.out.print("\n\nParcel\n");
    System.out.format("%20s   %-10s %-15s %-10s %-20s %-7s %-10s %-20s %-23s %-30s%n",
            "orderNumber", "category", "massInKilogram", "fragility", "dateOfReceiving",
            "sender", "recepient", "senderIdDepartment",
            "recepientIdDepartment", "parcelOnWayRouteNumber");
    System.out.println(parcelController.getParcel(inputId));
  }

  private void createNewParcel() throws SQLException {
    Parcel parcel = readParcel();
    parcelController.setParcel(parcel);
  }

  private void updateParcel() throws SQLException {
    Parcel parcel = readParcel();
    parcelController.putParcel(parcel);
  }

  private void deleteParcel() throws SQLException {
    parcelController.removeParcel(readParcelId());
  }


  private ParcelOnWay readParcelOnWay() {
    System.out.println("Please write courier id:");
    final Integer inputCourierId = input.nextInt();

    return new ParcelOnWay(0, inputCourierId);
  }

  private Integer readParcelOnWayId() {
    System.out.println("Please write id of Parcel on way:");
    return input.nextInt();
  }

  private void printParcelOnWayTable() throws SQLException {
    List<ParcelOnWay> parcelOnWays = parcelOnWayController.getParcelOnWay();
    System.out.print("\n\nParcel on way\n");
    System.out.format("%3s   %-3s%n", "id", "courierId");
    for (ParcelOnWay parcelOnWay : parcelOnWays) {
      System.out.println(parcelOnWay);
    }
  }

  private void printRowFromParcelOnWayById() throws SQLException {
    int inputId = readParcelOnWayId();
    System.out.print("\n\nParcel on way\n");
    System.out.format("%3s   %-3s%n", "id", "courierId");
    System.out.println(parcelOnWayController.getParcelOnWay(inputId));
  }

  private void createNewParcelOnWay() throws SQLException {
    ParcelOnWay parcelOnWay = readParcelOnWay();
    parcelOnWayController.setParcelOnWay(parcelOnWay);
  }

  private void updateParcelOnWay() throws SQLException {
    ParcelOnWay parcelOnWay = readParcelOnWay();

    int inputId = readParcelOnWayId();
    parcelOnWay.setId(inputId);

    parcelOnWayController.putParcelOnWay(parcelOnWay);
  }

  private void deleteParcelOnWay() throws SQLException {
    parcelOnWayController.removeParcelOnWay(readParcelOnWayId());
  }


  private Password readPassword() {
    System.out.println("Please write password:");
    final String inputPassword = input.nextLine();

    return new Password(0, inputPassword);
  }

  private Integer readPasswordId() {
    System.out.println("Please write id of Password:");
    return input.nextInt();
  }

  private void printPasswordTable() throws SQLException {
    List<Password> passwords = passwordController.getPassword();
    System.out.print("\n\nPassword\n");
    System.out.format("%3s   %-20s%n", "id", "password");
    for (Password password : passwords) {
      System.out.println(password);
    }
  }

  private void printRowFromPasswordById() throws SQLException {
    int inputId = readPasswordId();
    System.out.print("\n\nPassword\n");
    System.out.format("%3s   %-20s%n", "id", "password");
    System.out.println(passwordController.getPassword(inputId));
  }

  private void createNewPassword() throws SQLException {
    Password password = readPassword();
    passwordController.setPassword(password);
  }

  private void updatePassword() throws SQLException {
    Password password = readPassword();

    int inputId = readPasswordId();
    password.setId(inputId);

    passwordController.putPassword(password);
  }

  private void deletePassword() throws SQLException {
    passwordController.removePassword(readPasswordId());
  }


  private Region readRegion() {
    System.out.println("Please write region:");
    final String inputRegion = input.nextLine();

    return new Region(0, inputRegion);
  }

  private Integer readRegionId() {
    System.out.println("Please write id of Region:");
    return input.nextInt();
  }

  private void printRegionTable() throws SQLException {
    List<Region> regions = regionController.getRegion();
    System.out.print("\n\nRegion\n");
    System.out.format("%3s   %-20s%n", "id", "region");
    for (Region region : regions) {
      System.out.println(region);
    }
  }

  private void printRowFromRegionById() throws SQLException {
    int inputId = readRegionId();
    System.out.print("\n\nRegion\n");
    System.out.format("%3s   %-20s%n", "id", "region");
    System.out.println(regionController.getRegion(inputId));
  }

  private void createNewRegion() throws SQLException {
    Region region = readRegion();
    regionController.setRegion(region);
  }

  private void updateRegion() throws SQLException {
    Region region = readRegion();

    int inputId = readRegionId();
    region.setId(inputId);

    regionController.putRegion(region);
  }

  private void deleteRegion() throws SQLException {
    regionController.removeRegion(readRegionId());
  }


  private User readUser() {
    System.out.println("Please write phone number:");
    final String inputPhoneNumber = input.nextLine();

    System.out.println("Please write address id:");
    final Integer inputAddressId = input.nextInt();

    System.out.println("Please write name id:");
    final Integer inputNameId = input.nextInt();

    System.out.println("Please write password id:");
    final Integer inputPasswordId = input.nextInt();

    return new User(0, inputPhoneNumber, inputAddressId, inputNameId, inputPasswordId);
  }

  private Integer readUserId() {
    System.out.println("Please write id of User:");
    return input.nextInt();
  }

  private void printUserTable() throws SQLException {
    List<User> users = userController.getUser();
    System.out.print("\n\nUser\n");
    System.out.format("%3s   %-15s %-10s %-6s %-5s%n", "id", "phoneNumber",
            "addressId", "nameId", "passwordId");
    for (User user : users) {
      System.out.println(user);
    }
  }

  private void printRowFromUserById() throws SQLException {
    int inputId = readUserId();
    System.out.print("\n\nUser\n");
    System.out.format("%3s   %-15s %-10s %-6s %-5s%n", "id", "phoneNumber",
            "addressId", "nameId", "passwordId");
    System.out.println(userController.getUser(inputId));
  }

  private void createNewUser() throws SQLException {
    User user = readUser();
    userController.setUser(user);
  }

  private void updateUser() throws SQLException {
    User user = readUser();

    int inputId = readUserId();
    user.setId(inputId);

    userController.putUser(user);
  }

  private void deleteUser() throws SQLException {
    userController.removeUser(readUserId());
  }


  private UserOperator readUserOperator() {
    System.out.println("Please write user id:");
    final Integer inputUserId = input.nextInt();

    System.out.println("Please write operator id:");
    final Integer inputUserOperatorId = input.nextInt();

    return new UserOperator(0, inputUserId, inputUserOperatorId);
  }

  private Integer readUserOperatorId() {
    System.out.println("Please write id of User-Operator:");
    return input.nextInt();
  }

  private void printUserOperatorTable() throws SQLException {
    List<UserOperator> userOperators = userOperatorController.getUserOperator();
    System.out.print("\n\nUser-Operator\n");
    System.out.format("%3s   %-7s %-5s%n", "id", "userId", "operatorId");
    for (UserOperator userOperator : userOperators) {
      System.out.println(userOperator);
    }
  }

  private void printRowFromUserOperatorById() throws SQLException {
    int inputId = readUserOperatorId();
    System.out.print("\n\nUser-Operator\n");
    System.out.format("%3s   %-7s %-5s%n", "id", "userId", "operatorId");
    System.out.println(userOperatorController.getUserOperator(inputId));
  }

  private void createNewUserOperator() throws SQLException {
    UserOperator userOperator = readUserOperator();
    userOperatorController.setUserOperator(userOperator);
  }

  private void updateUserOperator() throws SQLException {
    UserOperator userOperator = readUserOperator();

    int inputId = readUserOperatorId();
    userOperator.setId(inputId);

    userOperatorController.putUserOperator(userOperator);
  }

  private void deleteUserOperator() throws SQLException {
    userOperatorController.removeUserOperator(readUserOperatorId());
  }

  private void printAllTables() throws SQLException {
    printAddressTable();
    printCityTable();
    printCourierTable();
    printDepartmentTable();
    printNameTable();
    printOperatorTable();
    printParcelTable();
    printParcelOnWayTable();
    printPasswordTable();
    printRegionTable();
    printUserTable();
    printUserOperatorTable();
  }
}