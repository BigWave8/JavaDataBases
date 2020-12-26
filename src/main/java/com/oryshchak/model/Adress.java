package com.oryshchak.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "adress", schema = "oryshchak")
public class Adress {
  private Integer id;
  private String street;
  private String houseNumber;
  private String apartmentNumber;
  private String index;
  private City cityByCityId;
  private Set<Department> departments;
  private Set<User> users;

  public static void printHeaders() {
    System.out.format(
            "%n%3s    %-20s %-12s %-15s %-7s %-15s%n",
            "id",
            "street",
            "houseNumber",
            "apartmentNumber",
            "index",
            "cityByCityId");
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
  @Column(name = "street")
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  @Basic
  @Column(name = "house_number")
  public String getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }

  @Basic
  @Column(name = "apartment_number")
  public String getApartmentNumber() {
    return apartmentNumber;
  }

  public void setApartmentNumber(String apartmentNumber) {
    this.apartmentNumber = apartmentNumber;
  }

  @Basic
  @Column(name = "index")
  public String getIndex() {
    return index;
  }

  public void setIndex(String index) {
    this.index = index;
  }

  @ManyToOne
  @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = true)
  public City getCityByCityId() {
    return cityByCityId;
  }

  public void setCityByCityId(City cityByCityId) {
    this.cityByCityId = cityByCityId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Adress that = (Adress) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (street != null ? !street.equals(that.street) : that.street != null) {
      return false;
    }
    if (houseNumber != null ? !houseNumber.equals(that.houseNumber) : that.houseNumber != null) {
      return false;
    }
    if (apartmentNumber != null ? !apartmentNumber
            .equals(that.apartmentNumber) : that.apartmentNumber != null) {
      return false;
    }
    if (index != null ? !index.equals(that.index) : that.index != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (street != null ? street.hashCode() : 0);
    result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
    result = 31 * result + (apartmentNumber != null ? apartmentNumber.hashCode() : 0);
    result = 31 * result + (index != null ? index.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "adressByAdressId")
  public Set<Department> getDepartments() {
    return departments;
  }

  public void setDepartments(Set<Department> departments) {
    this.departments = departments;
  }

  @OneToMany(mappedBy = "adressByAdressId")
  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return String
            .format("%3s    %-20s %-12s %-15s %-7s %-15s",
            id, street, houseNumber, apartmentNumber, index, cityByCityId.getId());
  }
}
