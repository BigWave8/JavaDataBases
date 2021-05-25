package com.oryshchak.dto;

import com.oryshchak.controller.implementation.DepartmentController;
import com.oryshchak.controller.implementation.ParcelController;
import com.oryshchak.controller.implementation.ParcelOnWayController;
import com.oryshchak.controller.implementation.UserController;
import com.oryshchak.model.Parcel;
import org.springframework.hateoas.ResourceSupport;
import java.math.BigDecimal;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ParcelDto extends ResourceSupport {

  private final Parcel parcel;

  public ParcelDto(Parcel parcel) {
    this.parcel = parcel;
    add(linkTo(methodOn(ParcelController.class).getParcel(parcel.getOrderNumber())).withSelfRel());
    add(linkTo(methodOn(UserController.class)
            .getUser(parcel.getUserBySenderId().getId())).withRel("sender"));
    add(linkTo(methodOn(UserController.class)
            .getUser(parcel.getUserByRecepientId().getId())).withRel("recepient"));
    add(linkTo(methodOn(DepartmentController.class)
            .getDepartment(parcel.getDepartmentByRecepientId().getId()))
            .withRel("sender-department"));
    add(linkTo(methodOn(DepartmentController.class)
            .getDepartment(parcel.getDepartmentByRecepientId().getId()))
            .withRel("recepient-department"));
    add(linkTo(methodOn(ParcelOnWayController.class)
            .getParcelOnWay(parcel.getParcelOnWayByRouteNumberId().getId()))
            .withRel("parcel-on-way"));
  }

  public String getOrderNumber() {
    return parcel.getOrderNumber();
  }

  public String getCategory() {
    return parcel.getCategory();
  }

  public BigDecimal getMassInKilogram() {
    return parcel.getMassInKilogram();
  }

  public Byte getFragility() {
    return parcel.getFragility();
  }

  public String getDateOfReceiving() {
    return parcel.getDateOfReceiving();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    ParcelDto parcelDto = (ParcelDto) o;

    return parcel != null ? parcel.equals(parcelDto.parcel) : parcelDto.parcel == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (parcel != null ? parcel.hashCode() : 0);
    return result;
  }
}
