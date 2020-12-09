package com.oryshchak.persistent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
  private static String username;
  private static String password;
  private static String url;
  private static Connection connection = null;

  public static Connection getConnection() {
    if (connection == null) {
      try {
        getCredentials();
        connection = DriverManager.getConnection(url, username, password);
      } catch (SQLException throwables) {
        System.out.println("SQL Exception:" + throwables.getMessage());
        System.out.println("SQL State:" + throwables.getSQLState());
        System.out.println("Vendor Error:" + throwables.getErrorCode());
      }
    }
    return connection;
  }

  public static void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException throwable) {
        System.out.println("Can't close connection, Exception is:" + throwable.getMessage());
        System.out.println("State:" + throwable.getMessage());
        System.out.println("Vendor Error:" + throwable.getMessage());
      }
    }
  }

  private static void getCredentials() {
    File file = new File("src//main//resources//credential.txt");

    try (BufferedReader fileScanner = new BufferedReader(
            new FileReader(file, StandardCharsets.UTF_8))) {
      url = fileScanner.readLine();
      username = fileScanner.readLine();
      password = fileScanner.readLine();
    } catch (IOException e) {
      System.out.println("File credential not found");
      System.out.println("Please insert into resources file");
      System.out.println("Exception:" + e.getMessage());
    }
  }
}