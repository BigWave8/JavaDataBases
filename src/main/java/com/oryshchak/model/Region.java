package com.oryshchak.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "region", schema = "oryshchak")
public class Region {
  private Integer id;
  private String region;
  private Set<City> cities;

  public static void printHeaders() {
    System.out.format(
            "%n%3s    %-15s%n",
            "id",
            "region");
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "region")
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

    Region that = (Region) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (region != null ? !region.equals(that.region) : that.region != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (region != null ? region.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "regionByRegionId")
  public Set<City> getCities() {
    return cities;
  }

  public void setCities(Set<City> cities) {
    this.cities = cities;
  }

  @Override
  public String toString() {
    return String.format("%3s    %-15s", id, region);
  }
}
