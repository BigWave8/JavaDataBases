package com.oryshchak.dto;

import com.oryshchak.controller.implementation.CityController;
import com.oryshchak.controller.implementation.RegionController;
import com.oryshchak.model.Region;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class RegionDto extends ResourceSupport {

  private final Region region;

  public RegionDto(Region region) {
    this.region = region;
    add(linkTo(methodOn(RegionController.class).getRegion(region.getId())).withSelfRel());
    add(linkTo(methodOn(CityController.class).getCitiesByRegion(region.getId())).withRel("city"));
  }

  public Integer getRegionId() {
    return region.getId();
  }

  public String getRegion() {
    return region.getRegion();
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

    RegionDto regionDto = (RegionDto) o;

    return region != null ? region.equals(regionDto.region) : regionDto.region == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (region != null ? region.hashCode() : 0);
    return result;
  }
}
