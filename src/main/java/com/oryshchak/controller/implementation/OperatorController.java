package com.oryshchak.controller.implementation;

import com.oryshchak.controller.ControllerWithDto;
import com.oryshchak.dto.OperatorDto;
import com.oryshchak.model.Operator;
import com.oryshchak.service.OperatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class OperatorController implements ControllerWithDto<OperatorDto, Operator> {

  private final OperatorService service;

  public OperatorController(OperatorService operatorService) {
    this.service = operatorService;
  }

  @GetMapping(value = "/bigwave/operator")
  public ResponseEntity<List<OperatorDto>> getOperators() {
    List<Operator> operators = service.getEntities();
    List<OperatorDto> operatorsDto = createDtos(operators);
    return new ResponseEntity<>(operatorsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/operator/{operatorId}")
  public ResponseEntity<OperatorDto> getOperator(@PathVariable Integer operatorId) {
    Operator operator = service.getEntity(operatorId);
    OperatorDto operatorDto = createDto(operator);
    return new ResponseEntity<>(operatorDto, HttpStatus.OK);
  }

  @PostMapping(value = "/bigwave/operator")
  public ResponseEntity<OperatorDto> setOperator(@RequestBody Operator operator) {
    Operator newOperator = service.createEntity(operator);
    OperatorDto operatorDto = createDto(newOperator);
    return new ResponseEntity<>(operatorDto, HttpStatus.OK);
  }

  @PutMapping(value = "/bigwave/operator/{operatorId}")
  public ResponseEntity<OperatorDto> updateOperator(
          @RequestBody Operator operator, @PathVariable Integer operatorId) {
    Operator newOperator = service.updateEntity(operator, operatorId);
    OperatorDto operatorDto = createDto(newOperator);
    return new ResponseEntity<>(operatorDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bigwave/operator/{operatorId}")
  public ResponseEntity<Operator> deleteOperator(@PathVariable Integer operatorId) {
    service.deleteEntity(operatorId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/operator/name/{nameId}")
  public ResponseEntity<List<OperatorDto>> getOperatorsByName(@PathVariable Integer nameId) {
    Set<Operator> operators = service.getOperatorsByNameId(nameId);
    List<OperatorDto> operatorsDto = createDtos(operators);
    return new ResponseEntity<>(operatorsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/operator/user/{userId}")
  public ResponseEntity<List<OperatorDto>> getOperatorsByUser(@PathVariable Integer userId) {
    Set<Operator> operators = service.getOperatorsByUserId(userId);
    List<OperatorDto> operatorsDto = createDtos(operators);
    return new ResponseEntity<>(operatorsDto, HttpStatus.OK);
  }

  @Override
  public List<OperatorDto> createDtos(Iterable<Operator> operators) {
    List<OperatorDto> operatorsDto = new ArrayList<>();
    for (Operator operator : operators) {
      OperatorDto operatorDto = new OperatorDto(operator);
      operatorsDto.add(operatorDto);
    }
    return operatorsDto;
  }

  @Override
  public OperatorDto createDto(Operator operator) {
    return new OperatorDto(operator);
  }
}
