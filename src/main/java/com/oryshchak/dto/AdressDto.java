package com.oryshchak.dto;

import com.oryshchak.controller.implementation.AdressController;
import com.oryshchak.controller.implementation.CityController;
import com.oryshchak.controller.implementation.DepartmentController;
import com.oryshchak.controller.implementation.UserController;
import com.oryshchak.model.Adress;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class AdressDto extends ResourceSupport {

  private final Adress adress;

  public AdressDto(Adress adress) {
    this.adress = adress;
    add(linkTo(methodOn(AdressController.class).getAdress(adress.getId())).withSelfRel());
    add(linkTo(methodOn(UserController.class).getUsersByAdress(adress.getId())).withRel("user"));
    add(linkTo(methodOn(DepartmentController.class)
            .getDepartmentsByAdress(adress.getId())).withRel("department"));
    add(linkTo(methodOn(CityController.class)
            .getCity(adress.getCityByCityId().getId())).withRel("city"));
  }

  public Integer getAdressId() {
    return adress.getId();
  }

  public String getStreet() {
    return adress.getStreet();
  }

  public String getHouseNumber() {
    return adress.getHouseNumber();
  }

  public String getApartmentNumber() {
    return adress.getApartmentNumber();
  }

  public String getIndex() {
    return adress.getIndex();
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

    AdressDto adressDto = (AdressDto) o;

    return adress != null ? adress.equals(adressDto.adress) : adressDto.adress == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (adress != null ? adress.hashCode() : 0);
    return result;
  }
}
