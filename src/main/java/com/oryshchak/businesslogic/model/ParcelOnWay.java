package com.oryshchak.businesslogic.model;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.PrimaryKey;
import com.oryshchak.businesslogic.model.annotations.Table;

@Table(name = "parcel_on_way")
public class ParcelOnWay {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;

  @Column(name = "courier_id", type = "int")
  private Integer courierId;

  public ParcelOnWay() {
  }

  public ParcelOnWay(Integer id, Integer courierId) {
    this.id = id;
    this.courierId = courierId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCourierId() {
    return courierId;
  }

  public void setCourierId(Integer courierId) {
    this.courierId = courierId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ParcelOnWay that = (ParcelOnWay) o;

    if (!id.equals(that.id)) {
      return false;
    }
    return courierId.equals(that.courierId);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + courierId.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return String.format("%3s   %-3s", id, courierId);
  }
}
