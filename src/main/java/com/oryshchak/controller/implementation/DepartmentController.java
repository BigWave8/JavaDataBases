package com.oryshchak.controller.implementation;

import com.oryshchak.controller.ControllerWithDto;
import com.oryshchak.dto.DepartmentDto;
import com.oryshchak.model.Department;
import com.oryshchak.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class DepartmentController implements ControllerWithDto<DepartmentDto, Department> {

  private final DepartmentService service;

  public DepartmentController(DepartmentService departmentService) {
    this.service = departmentService;
  }

  @GetMapping(value = "/bigwave/department")
  public ResponseEntity<List<DepartmentDto>> getDepartments() {
    List<Department> departments = service.getEntities();
    List<DepartmentDto> departmentsDto = createDtos(departments);
    return new ResponseEntity<>(departmentsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/department/{departmentId}")
  public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Integer departmentId) {
    Department department = service.getEntity(departmentId);
    DepartmentDto departmentDto = createDto(department);
    return new ResponseEntity<>(departmentDto, HttpStatus.OK);
  }

  @PostMapping(value = "/bigwave/department")
  public ResponseEntity<DepartmentDto> setDepartment(@RequestBody Department department) {
    Department newDepartment = service.createEntity(department);
    DepartmentDto departmentDto = createDto(newDepartment);
    return new ResponseEntity<>(departmentDto, HttpStatus.OK);
  }

  @PutMapping(value = "/bigwave/department/{departmentId}")
  public ResponseEntity<DepartmentDto> updateDepartment(
          @RequestBody Department department, @PathVariable Integer departmentId) {
    Department newDepartment = service.updateEntity(department, departmentId);
    DepartmentDto departmentDto = createDto(newDepartment);
    return new ResponseEntity<>(departmentDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bigwave/department/{departmentId}")
  public ResponseEntity<Department> deleteDepartment(@PathVariable Integer departmentId) {
    service.deleteEntity(departmentId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/department/adress/{adressId}")
  public ResponseEntity<List<DepartmentDto>> getDepartmentsByAdress(
          @PathVariable Integer adressId) {
    Set<Department> departments = service.getDepartmentsByAdressId(adressId);
    List<DepartmentDto> departmentsDto = createDtos(departments);
    return new ResponseEntity<>(departmentsDto, HttpStatus.OK);
  }

  @Override
  public List<DepartmentDto> createDtos(Iterable<Department> departments) {
    List<DepartmentDto> departmentsDto = new ArrayList<>();
    for (Department department : departments) {
      DepartmentDto departmentDto = new DepartmentDto(department);
      departmentsDto.add(departmentDto);
    }
    return departmentsDto;
  }

  @Override
  public DepartmentDto createDto(Department department) {
    return new DepartmentDto(department);
  }
}
