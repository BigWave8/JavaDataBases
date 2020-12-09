package com.oryshchak.businesslogic.model;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.PrimaryKey;
import com.oryshchak.businesslogic.model.annotations.Table;

@Table(name = "department")
public class Department {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;

  @Column(name = "index", type = "int")
  private Integer index;

  @Column(name = "adress_id", type = "int")
  private Integer addressId;

  public Department() {
  }

  public Department(Integer id, Integer index, Integer addressId) {
    this.id = id;
    this.index = index;
    this.addressId = addressId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex(Integer index) {
    this.index = index;
  }

  public Integer getAddressId() {
    return addressId;
  }

  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Department that = (Department) o;

    if (!id.equals(that.id)) {
      return false;
    }
    if (index != null ? !index.equals(that.index) : that.index != null) {
      return false;
    }
    return addressId.equals(that.addressId);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + (index != null ? index.hashCode() : 0);
    result = 31 * result + addressId.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return String.format("%3s   %-7s %-5s", id, index, addressId);
  }
}
