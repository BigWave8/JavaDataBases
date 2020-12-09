package com.oryshchak.businesslogic.model;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.PrimaryKey;
import com.oryshchak.businesslogic.model.annotations.Table;

@Table(name = "city")
public class City {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;

  @Column(name = "city")
  private String city;

  @Column(name = "region_id", type = "int")
  private Integer regionId;

  public City() {
  }

  public City(Integer id, String city, Integer regionId) {
    this.id = id;
    this.city = city;
    this.regionId = regionId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Integer getRegionId() {
    return regionId;
  }

  public void setRegionId(Integer regionId) {
    this.regionId = regionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    City city1 = (City) o;

    if (!id.equals(city1.id)) {
      return false;
    }
    if (city != null ? !city.equals(city1.city) : city1.city != null) {
      return false;
    }
    return regionId != null ? regionId.equals(city1.regionId) : city1.regionId == null;
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + (city != null ? city.hashCode() : 0);
    result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%3s   %-20s %-5s", id, city, regionId);
  }
}
