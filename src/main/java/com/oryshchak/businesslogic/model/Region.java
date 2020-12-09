package com.oryshchak.businesslogic.model;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.PrimaryKey;
import com.oryshchak.businesslogic.model.annotations.Table;

@Table(name = "region")
public class Region {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;

  @Column(name = "region", length = 40)
  private String region;

  public Region() {
  }

  public Region(Integer id, String region) {
    this.id = id;
    this.region = region;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Region region1 = (Region) o;

    if (!id.equals(region1.id)) {
      return false;
    }
    return region.equals(region1.region);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + region.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return String.format("%3s   %-20s", id, region);
  }
}
