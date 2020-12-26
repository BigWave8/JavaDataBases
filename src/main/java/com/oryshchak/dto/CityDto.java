package com.oryshchak.dto;

import com.oryshchak.controller.implementation.AdressController;
import com.oryshchak.controller.implementation.CityController;
import com.oryshchak.controller.implementation.RegionController;
import com.oryshchak.model.City;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class CityDto extends ResourceSupport {

  private final City city;

  public CityDto(City city) {
    this.city = city;
    add(linkTo(methodOn(CityController.class).getCity(city.getId())).withSelfRel());
    add(linkTo(methodOn(AdressController.class).getAdressesByCity(city.getId())).withRel("adress"));
    add(linkTo(methodOn(RegionController.class)
            .getRegion(city.getRegionByRegionId().getId())).withRel("region"));
  }

  public Integer getCityId() {
    return city.getId();
  }

  public String getCity() {
    return city.getCity();
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

    CityDto cityDto = (CityDto) o;

    return city != null ? city.equals(cityDto.city) : cityDto.city == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (city != null ? city.hashCode() : 0);
    return result;
  }
}
