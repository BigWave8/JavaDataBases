package com.oryshchak.view;

import java.io.IOException;
import java.sql.SQLException;

public interface Printable {
  void print() throws SQLException, IOException;
}