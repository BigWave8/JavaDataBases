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
  private User userBySenderIdUser;
  private User userByRecepientIdUser;
  private Department departmentBySenderIdDepartment;
  private Department departmentByRecepientIdDepartment;
  private ParcelOnWay parcelOnWayByRecepientIdParcelOnWay;

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
  public User getUserBySenderIdUser() {
    return userBySenderIdUser;
  }

  public void setUserBySenderIdUser(User userBySenderIdUser) {
    this.userBySenderIdUser = userBySenderIdUser;
  }

  @ManyToOne
  @JoinColumn(name = "recepient", referencedColumnName = "id", nullable = false)
  public User getUserByRecepientIdUser() {
    return userByRecepientIdUser;
  }

  public void setUserByRecepientIdUser(User userByRecepientIdUser) {
    this.userByRecepientIdUser = userByRecepientIdUser;
  }

  @ManyToOne
  @JoinColumn(name = "sender_id_department", referencedColumnName = "id", nullable = false)
  public Department getDepartmentBySenderIdDepartment() {
    return departmentBySenderIdDepartment;
  }

  public void setDepartmentBySenderIdDepartment(Department departmentBySenderIdDepartment) {
    this.departmentBySenderIdDepartment = departmentBySenderIdDepartment;
  }

  @ManyToOne
  @JoinColumn(name = "recepient_id_department", referencedColumnName = "id", nullable = false)
  public Department getDepartmentByRecepientIdDepartment() {
    return departmentByRecepientIdDepartment;
  }

  public void setDepartmentByRecepientIdDepartment(Department departmentByRecepientIdDepartment) {
    this.departmentByRecepientIdDepartment = departmentByRecepientIdDepartment;
  }

  @ManyToOne
  @JoinColumn(name = "parcel_on_way_route_number", referencedColumnName = "id", nullable = true)
  public ParcelOnWay getParcelOnWayByRecepientIdParcelOnWay() {
    return parcelOnWayByRecepientIdParcelOnWay;
  }

  public void setParcelOnWayByRecepientIdParcelOnWay(ParcelOnWay
                                                             parcelOnWayByRecepientIdParcelOnWay) {
    this.parcelOnWayByRecepientIdParcelOnWay = parcelOnWayByRecepientIdParcelOnWay;
  }

  @Override
  public String toString() {
    return String.format("%20s    %-20s %-15s %-10s %-20s %-20s %-24s %-30s %-35s %-30s",
            orderNumber, category, massInKilogram, fragility, dateOfReceiving,
            userBySenderIdUser.getId(), userByRecepientIdUser.getId(),
            departmentBySenderIdDepartment.getId(), departmentByRecepientIdDepartment.getId(),
            parcelOnWayByRecepientIdParcelOnWay.getId());
  }
}
