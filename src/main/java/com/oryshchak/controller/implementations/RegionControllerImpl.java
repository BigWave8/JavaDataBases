package com.oryshchak.controller.implementations;

import com.oryshchak.business.GeneralService;
import com.oryshchak.business.implementations.RegionServiceImpl;
import com.oryshchak.controller.RegionController;
import com.oryshchak.model.Region;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class RegionControllerImpl implements RegionController {

  private final Scanner input;

  public RegionControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public GeneralService<Region, Integer> getService() {
    return new RegionServiceImpl();
  }

  @Override
  public void printHeaders() {
    Region.printHeaders();
  }

  @Override
  public Region inputEntity() throws SQLException {
    Region region = new Region();

    System.out.println("Please write region:");
    region.setRegion(input.nextLine());

    return region;
  }

  @Override
  public Region inputCreateEntity() throws SQLException, IOException {
    Region region = inputEntity();

    System.out.println("Please write id:");
    region.setId(input.nextInt());

    return region;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of Region:");
    return input.nextInt();
  }
}
