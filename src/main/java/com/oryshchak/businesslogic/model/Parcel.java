package com.oryshchak.businesslogic.model;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.PrimaryKey;
import com.oryshchak.businesslogic.model.annotations.Table;

import java.math.BigDecimal;

@Table(name = "parcel")
public class Parcel {

  @PrimaryKey
  @Column(name = "order_number", length = 20)
  private String orderNumber;

  @Column(name = "category")
  private String category;

  @Column(name = "mass_in_kilogram", type = "bigDecimal")
  private BigDecimal massInKilogram;

  @Column(name = "fragility", type = "bool")
  private Boolean fragility;

  @Column(name = "date_of_receiving")
  private String dateOfReceiving;

  @Column(name = "sender", type = "int")
  private Integer sender;

  @Column(name = "recepient", type = "int")
  private Integer recepient;

  @Column(name = "sender_id_department", type = "int")
  private Integer senderIdDepartment;

  @Column(name = "recepient_id_department", type = "int")
  private Integer recepientIdDepartment;

  @Column(name = "parcel_on_way_route_number", type = "int")
  private Integer parcelOnWayRouteNumber;

  public Parcel() {
  }

  public Parcel(String orderNumber, String category, BigDecimal massInKilogram, Boolean fragility,
                String dateOfReceiving, Integer sender, Integer recepient,
                Integer senderIdDepartment, Integer recepientIdDepartment,
                Integer parcelOnWayRouteNumber) {
    this.orderNumber = orderNumber;
    this.category = category;
    this.massInKilogram = massInKilogram;
    this.fragility = fragility;
    this.dateOfReceiving = dateOfReceiving;
    this.sender = sender;
    this.recepient = recepient;
    this.senderIdDepartment = senderIdDepartment;
    this.recepientIdDepartment = recepientIdDepartment;
    this.parcelOnWayRouteNumber = parcelOnWayRouteNumber;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public BigDecimal getMassInKilogram() {
    return massInKilogram;
  }

  public void setMassInKilogram(BigDecimal massInKilogram) {
    this.massInKilogram = massInKilogram;
  }

  public Boolean getFragility() {
    return fragility;
  }

  public void setFragility(Boolean fragility) {
    this.fragility = fragility;
  }

  public String getDateOfReceiving() {
    return dateOfReceiving;
  }

  public void setDateOfReceiving(String dateOfReceiving) {
    this.dateOfReceiving = dateOfReceiving;
  }

  public Integer getSender() {
    return sender;
  }

  public void setSender(Integer sender) {
    this.sender = sender;
  }

  public Integer getRecepient() {
    return recepient;
  }

  public void setRecepient(Integer recepient) {
    this.recepient = recepient;
  }

  public Integer getSenderIdDepartment() {
    return senderIdDepartment;
  }

  public void setSenderIdDepartment(Integer senderIdDepartment) {
    this.senderIdDepartment = senderIdDepartment;
  }

  public Integer getRecepientIdDepartment() {
    return recepientIdDepartment;
  }

  public void setRecepientIdDepartment(Integer recepientIdDepartment) {
    this.recepientIdDepartment = recepientIdDepartment;
  }

  public Integer getParcelOnWayRouteNumber() {
    return parcelOnWayRouteNumber;
  }

  public void setParcelOnWayRouteNumber(Integer parcelOnWayRouteNumber) {
    this.parcelOnWayRouteNumber = parcelOnWayRouteNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Parcel parcel = (Parcel) o;

    if (!orderNumber.equals(parcel.orderNumber)) {
      return false;
    }
    if (!category.equals(parcel.category)) {
      return false;
    }
    if (!massInKilogram.equals(parcel.massInKilogram)) {
      return false;
    }
    if (!fragility.equals(parcel.fragility)) {
      return false;
    }
    if (!dateOfReceiving.equals(parcel.dateOfReceiving)) {
      return false;
    }
    if (!sender.equals(parcel.sender)) {
      return false;
    }
    if (!recepient.equals(parcel.recepient)) {
      return false;
    }
    if (!senderIdDepartment.equals(parcel.senderIdDepartment)) {
      return false;
    }
    if (!recepientIdDepartment.equals(parcel.recepientIdDepartment)) {
      return false;
    }
    return parcelOnWayRouteNumber != null
            ? parcelOnWayRouteNumber.equals(parcel.parcelOnWayRouteNumber) :
            parcel.parcelOnWayRouteNumber == null;
  }

  @Override
  public int hashCode() {
    int result = orderNumber.hashCode();
    result = 31 * result + category.hashCode();
    result = 31 * result + massInKilogram.hashCode();
    result = 31 * result + fragility.hashCode();
    result = 31 * result + dateOfReceiving.hashCode();
    result = 31 * result + sender.hashCode();
    result = 31 * result + recepient.hashCode();
    result = 31 * result + senderIdDepartment.hashCode();
    result = 31 * result + recepientIdDepartment.hashCode();
    result = 31 * result + (parcelOnWayRouteNumber != null ? parcelOnWayRouteNumber.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String
            .format("%20s   %-10s %-15s %-10s %-20s %-7s %-10s %-20s %-23s %-30s",
                    orderNumber, category, massInKilogram, fragility, dateOfReceiving,
                    sender, recepient, senderIdDepartment, recepientIdDepartment,
                    parcelOnWayRouteNumber);
  }
}
