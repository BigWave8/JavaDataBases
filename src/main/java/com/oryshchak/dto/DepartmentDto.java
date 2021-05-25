package com.oryshchak.dto;

import com.oryshchak.controller.implementation.AdressController;
import com.oryshchak.controller.implementation.DepartmentController;
import com.oryshchak.controller.implementation.ParcelController;
import com.oryshchak.model.Department;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class DepartmentDto extends ResourceSupport {

  private final Department department;

  public DepartmentDto(Department department) {
    this.department = department;
    add(linkTo(methodOn(DepartmentController.class)
            .getDepartment(department.getId())).withSelfRel());
    add(linkTo(methodOn(ParcelController.class)
            .getParcelsBySender(department.getId())).withRel("sender-department"));
    add(linkTo(methodOn(ParcelController.class)
            .getParcelsByRecepient(department.getId())).withRel("recepient-department"));
    add(linkTo(methodOn(AdressController.class)
            .getAdress(department.getAdressByAdressId().getId())).withRel("adress"));
  }

  public Integer getDepartmentId() {
    return department.getId();
  }

  public Integer getIndex() {
    return department.getIndex();
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

    DepartmentDto that = (DepartmentDto) o;

    return department != null ? department.equals(that.department) : that.department == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (department != null ? department.hashCode() : 0);
    return result;
  }
}
