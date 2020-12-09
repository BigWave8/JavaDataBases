package com.oryshchak.businesslogic.model;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.PrimaryKey;
import com.oryshchak.businesslogic.model.annotations.Table;

@Table(name = "adress")
public class Address {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;

  @Column(name = "street")
  private String street;

  @Column(name = "house_number", type = "int")
  private Integer houseNumber;

  @Column(name = "apartment_number", type = "int")
  private Integer apartmentNumber;

  @Column(name = "index", type = "int", length = 5)
  private Integer index;

  @Column(name = "city_id", type = "int")
  private Integer cityId;

  public Address() {
  }

  public Address(Integer id, String street, Integer houseNumber,
                 Integer apartmentNumber, Integer index, Integer cityId) {
    this.id = id;
    this.street = street;
    this.houseNumber = houseNumber;
    this.apartmentNumber = apartmentNumber;
    this.index = index;
    this.cityId = cityId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Integer getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(Integer houseNumber) {
    this.houseNumber = houseNumber;
  }

  public Integer getApartmentNumber() {
    return apartmentNumber;
  }

  public void setApartmentNumber(Integer apartmentNumber) {
    this.apartmentNumber = apartmentNumber;
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex(Integer index) {
    this.index = index;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Address address = (Address) o;

    if (!id.equals(address.id)) {
      return false;
    }
    if (street != null ? !street.equals(address.street) : address.street != null) {
      return false;
    }
    if (houseNumber != null ? !houseNumber.equals(address.houseNumber) :
            address.houseNumber != null) {
      return false;
    }
    if (!apartmentNumber.equals(address.apartmentNumber)) {
      return false;
    }
    if (!index.equals(address.index)) {
      return false;
    }
    return cityId.equals(address.cityId);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + (street != null ? street.hashCode() : 0);
    result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
    result = 31 * result + apartmentNumber.hashCode();
    result = 31 * result + index.hashCode();
    result = 31 * result + cityId.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return String
            .format("%3s   %-20s %-12s %-18s %-7s %-5s", id, street, houseNumber,
                    apartmentNumber, index, cityId);
  }
}
