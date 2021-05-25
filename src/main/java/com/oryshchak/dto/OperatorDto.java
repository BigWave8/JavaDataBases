package com.oryshchak.dto;

import com.oryshchak.controller.implementation.NameController;
import com.oryshchak.controller.implementation.OperatorController;
import com.oryshchak.controller.implementation.UserController;
import com.oryshchak.model.Operator;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class OperatorDto extends ResourceSupport {

  private final Operator operator;

  public OperatorDto(Operator operator) {
    this.operator = operator;
    add(linkTo(methodOn(OperatorController.class).getOperator(operator.getId())).withSelfRel());
    add(linkTo(methodOn(NameController.class)
            .getName(operator.getNameByNameId().getId())).withRel("name"));
    add(linkTo(methodOn(UserController.class).getUsersByOperator(operator.getId()))
                    .withRel("operator-user"));
  }

  public Integer getOperatorId() {
    return operator.getId();
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

    OperatorDto that = (OperatorDto) o;

    return operator != null ? operator.equals(that.operator) : that.operator == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (operator != null ? operator.hashCode() : 0);
    return result;
  }
}
