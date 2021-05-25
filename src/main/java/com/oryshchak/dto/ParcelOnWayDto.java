package com.oryshchak.dto;

import com.oryshchak.controller.implementation.*;
import com.oryshchak.model.ParcelOnWay;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ParcelOnWayDto extends ResourceSupport {

  private final ParcelOnWay parcelOnWay;

  public ParcelOnWayDto(ParcelOnWay parcelOnWay) {
    this.parcelOnWay = parcelOnWay;
    add(linkTo(methodOn(ParcelOnWayController.class)
            .getParcelOnWay(parcelOnWay.getId())).withSelfRel());
    add(linkTo(methodOn(ParcelController.class)
            .getParcelsByParcelOnWay(parcelOnWay.getId())).withRel("parcel"));
    add(linkTo(methodOn(CourierController.class)
            .getCourier(parcelOnWay.getCourierByCourierId().getId())).withRel("courier"));
  }

  public Integer getParcelOnWayId() {
    return parcelOnWay.getId();
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

    ParcelOnWayDto that = (ParcelOnWayDto) o;

    return parcelOnWay != null ? parcelOnWay.equals(that.parcelOnWay) : that.parcelOnWay == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (parcelOnWay != null ? parcelOnWay.hashCode() : 0);
    return result;
  }
}
