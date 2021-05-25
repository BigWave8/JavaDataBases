package com.oryshchak.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "parcel", schema = "oryshchak")
public class Parcel {
  private String orderNumber;
  private String category;
  private BigDecimal massInKilogram;
  private Byte fragility;
  private String dateOfReceiving;
  private User userBySenderId;
  private User userByRecepientId;
  private Department departmentBySenderId;
  private Department departmentByRecepientId;
  private ParcelOnWay parcelOnWayByRouteNumberId;

  public static void printHeaders() {
    System.out.format(
            "%n%20s    %-20s %-15s %-10s %-20s %-20s %-24s %-30s %-35s %-30s%n",
            "orderNumber",
            "category",
            "massInKilogram",
            "fragility",
            "dateOfReceiving",
            "userBySenderIdUser",
            "userByRecepientIdUser",
            "departmentBySenderIdDepartment",
            "departmentByRecepientIdDepartment",
            "parcelOnWayByRecepientIdParcelOnWay");
  }

  @Id
  @Column(name = "order_number")
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Basic
  @Column(name = "category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Basic
  @Column(name = "mass_in_kilogram")
  public BigDecimal getMassInKilogram() {
    return massInKilogram;
  }

  public void setMassInKilogram(BigDecimal massInKilogram) {
    this.massInKilogram = massInKilogram;
  }

  @Basic
  @Column(name = "fragility")
  public Byte getFragility() {
    return fragility;
  }

  public void setFragility(Byte fragility) {
    this.fragility = fragility;
  }

  @Basic
  @Column(name = "date_of_receiving")
  public String getDateOfReceiving() {
    return dateOfReceiving;
  }

  public void setDateOfReceiving(String dateOfReceiving) {
    this.dateOfReceiving = dateOfReceiving;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Parcel that = (Parcel) o;

    if (orderNumber != null ? !orderNumber.equals(that.orderNumber) : that.orderNumber != null) {
      return false;
    }
    if (category != null ? !category.equals(that.category) : that.category != null) {
      return false;
    }
    if (massInKilogram != null ? !massInKilogram.equals(that.massInKilogram) :
            that.massInKilogram != null) {
      return false;
    }
    if (fragility != null ? !fragility.equals(that.fragility) : that.fragility != null) {
      return false;
    }
    return dateOfReceiving != null ? dateOfReceiving.equals(that.dateOfReceiving) :
            that.dateOfReceiving == null;
  }

  @Override
  public int hashCode() {
    int result = orderNumber != null ? orderNumber.hashCode() : 0;
    result = 31 * result + (category != null ? category.hashCode() : 0);
    result = 31 * result + (massInKilogram != null ? massInKilogram.hashCode() : 0);
    result = 31 * result + (fragility != null ? fragility.hashCode() : 0);
    result = 31 * result + (dateOfReceiving != null ? dateOfReceiving.hashCode() : 0);
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "sender", referencedColumnName = "id", nullable = false)
  public User getUserBySenderId() {
    return userBySenderId;
  }

  public void setUserBySenderId(User userBySenderId) {
    this.userBySenderId = userBySenderId;
  }

  @ManyToOne
  @JoinColumn(name = "recepient", referencedColumnName = "id", nullable = false)
  public User getUserByRecepientId() {
    return userByRecepientId;
  }

  public void setUserByRecepientId(User userByRecepientId) {
    this.userByRecepientId = userByRecepientId;
  }

  @ManyToOne
  @JoinColumn(name = "sender_id_department", referencedColumnName = "id", nullable = false)
  public Department getDepartmentBySenderId() {
    return departmentBySenderId;
  }

  public void setDepartmentBySenderId(Department departmentBySenderId) {
    this.departmentBySenderId = departmentBySenderId;
  }

  @ManyToOne
  @JoinColumn(name = "recepient_id_department", referencedColumnName = "id", nullable = false)
  public Department getDepartmentByRecepientId() {
    return departmentByRecepientId;
  }

  public void setDepartmentByRecepientId(Department departmentByRecepientId) {
    this.departmentByRecepientId = departmentByRecepientId;
  }

  @ManyToOne
  @JoinColumn(name = "parcel_on_way_route_number", referencedColumnName = "id")
  public ParcelOnWay getParcelOnWayByRouteNumberId() {
    return parcelOnWayByRouteNumberId;
  }

  public void setParcelOnWayByRouteNumberId(ParcelOnWay parcelOnWayByRouteNumberId) {
    this.parcelOnWayByRouteNumberId = parcelOnWayByRouteNumberId;
  }

  @Override
  public String toString() {
    return String.format("%20s    %-20s %-15s %-10s %-20s %-20s %-24s %-30s %-35s %-30s",
            orderNumber, category, massInKilogram, fragility, dateOfReceiving,
            userBySenderId.getId(), userByRecepientId.getId(),
            departmentBySenderId.getId(), departmentByRecepientId.getId(),
            parcelOnWayByRouteNumberId.getId());
  }
}
