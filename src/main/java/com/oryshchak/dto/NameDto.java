package com.oryshchak.dto;

import com.oryshchak.controller.implementation.*;
import com.oryshchak.model.Name;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class NameDto extends ResourceSupport {

  private final Name name;

  public NameDto(Name name) {
    this.name = name;
    add(linkTo(methodOn(NameController.class).getName(name.getId())).withSelfRel());
    add(linkTo(methodOn(CourierController.class)
            .getCouriersByName(name.getId())).withRel("courier"));
    add(linkTo(methodOn(UserController.class)
            .getUsersByName(name.getId())).withRel("user"));
    add(linkTo(methodOn(OperatorController.class)
            .getOperatorsByName(name.getId())).withRel("operator"));
  }

  public Integer getNameId() {
    return name.getId();
  }

  public String getName() {
    return name.getName();
  }

  public String getSurname() {
    return name.getSurname();
  }

  public String getMiddleName() {
    return name.getMiddleName();
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

    NameDto nameDto = (NameDto) o;

    return name != null ? name.equals(nameDto.name) : nameDto.name == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
