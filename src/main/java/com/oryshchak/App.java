package com.oryshchak;

import com.oryshchak.persistent.ConnectionManager;
import com.oryshchak.view.View;
import java.io.IOException;
import java.sql.SQLException;

public class App {
  public static void main(final String[] args) throws IOException, SQLException {
    new View().show();
    ConnectionManager.closeConnection();
  }
}