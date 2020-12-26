package com.oryshchak.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "city", schema = "oryshchak")
public class City {
  private Integer id;
  private String city;
  private Region regionByRegionId;
  private Set<Adress> adresses;

  public static void printHeaders() {
    System.out.format(
            "%n%3s    %-20s %-20s%n",
            "id",
            "city",
            "regionByRegionId");
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
  @Column(name = "city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @ManyToOne
  @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = true)
  public Region getRegionByRegionId() {
    return regionByRegionId;
  }

  public void setRegionByRegionId(Region regionByRegionId) {
    this.regionByRegionId = regionByRegionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    City that = (City) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (city != null ? !city.equals(that.city) : that.city != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (city != null ? city.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "cityByCityId")
  public Set<Adress> getAdresses() {
    return adresses;
  }

  public void setAdresses(Set<Adress> adresses) {
    this.adresses = adresses;
  }

  @Override
  public String toString() {
    return String.format("%3s    %-20s %-20s", id, city, regionByRegionId.getId());
  }
}
