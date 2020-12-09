package com.oryshchak.businesslogic.model;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.PrimaryKey;
import com.oryshchak.businesslogic.model.annotations.Table;

@Table(name = "user")
public class User {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;

  @Column(name = "phone_number", length = 12)
  private String phoneNumber;

  @Column(name = "adress_id", type = "int")
  private Integer addressId;

  @Column(name = "name_id", type = "int")
  private Integer nameId;

  @Column(name = "password_id", type = "int")
  private Integer passwordId;

  public User() {
  }

  public User(Integer id, String phoneNumber, Integer addressId,
              Integer nameId, Integer passwordId) {
    this.id = id;
    this.phoneNumber = phoneNumber;
    this.addressId = addressId;
    this.nameId = nameId;
    this.passwordId = passwordId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Integer getAddressId() {
    return addressId;
  }

  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  public Integer getNameId() {
    return nameId;
  }

  public void setNameId(Integer nameId) {
    this.nameId = nameId;
  }

  public Integer getPasswordId() {
    return passwordId;
  }

  public void setPasswordId(Integer passwordId) {
    this.passwordId = passwordId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    User user = (User) o;

    if (!id.equals(user.id)) {
      return false;
    }
    if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) {
      return false;
    }
    if (!addressId.equals(user.addressId)) {
      return false;
    }
    if (!nameId.equals(user.nameId)) {
      return false;
    }
    return passwordId.equals(user.passwordId);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
    result = 31 * result + addressId.hashCode();
    result = 31 * result + nameId.hashCode();
    result = 31 * result + passwordId.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return String
            .format("%3s   %-15s %-10s %-6s %-5s", id, phoneNumber, addressId, nameId, passwordId);
  }
}
