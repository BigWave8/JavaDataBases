package com.oryshchak.dto;

import com.oryshchak.controller.implementation.CourierController;
import com.oryshchak.controller.implementation.NameController;
import com.oryshchak.controller.implementation.ParcelOnWayController;
import com.oryshchak.model.Courier;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class CourierDto extends ResourceSupport {

  private final Courier courier;

  public CourierDto(Courier courier) {
    this.courier = courier;
    add(linkTo(methodOn(CourierController.class).getCourier(courier.getId())).withSelfRel());
    add(linkTo(methodOn(ParcelOnWayController.class)
            .getParcelOnWaysByCourier(courier.getId())).withRel("parcel-on-way"));
    add(linkTo(methodOn(NameController.class)
            .getName(courier.getNameByNameId().getId())).withRel("name"));
  }

  public Integer getCourierId() {
    return courier.getId();
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

    CourierDto that = (CourierDto) o;

    return courier != null ? courier.equals(that.courier) : that.courier == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (courier != null ? courier.hashCode() : 0);
    return result;
  }
}
