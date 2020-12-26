package com.oryshchak.dto;

import com.oryshchak.controller.implementation.*;
import com.oryshchak.model.User;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class UserDto extends ResourceSupport {

  private final User user;

  public UserDto(User user) {
    this.user = user;
    add(linkTo(methodOn(UserController.class).getUser(user.getId())).withSelfRel());
    add(linkTo(methodOn(ParcelController.class)
            .getParcelsBySender(user.getId())).withRel("sender"));
    add(linkTo(methodOn(ParcelController.class)
            .getParcelsByRecepient(user.getId())).withRel("recepient"));
    add(linkTo(methodOn(NameController.class)
            .getName(user.getNameByNameId().getId())).withRel("name"));
    add(linkTo(methodOn(AdressController.class)
            .getAdress(user.getAdressByAdressId().getId())).withRel("adress"));
    add(linkTo(methodOn(OperatorController.class).getOperatorsByUser(user.getId()))
            .withRel("user-operator"));
  }

  public Integer getUserId() {
    return user.getId();
  }

  public String getPhoneNumber() {
    return user.getPhoneNumber();
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

    UserDto userDto = (UserDto) o;

    return user != null ? user.equals(userDto.user) : userDto.user == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (user != null ? user.hashCode() : 0);
    return result;
  }
}
