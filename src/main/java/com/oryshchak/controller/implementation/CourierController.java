package com.oryshchak.controller.implementation;

import com.oryshchak.controller.ControllerWithDto;
import com.oryshchak.dto.CourierDto;
import com.oryshchak.model.Courier;
import com.oryshchak.service.CourierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class CourierController implements ControllerWithDto<CourierDto, Courier> {
  private final CourierService service;

  public CourierController(CourierService courierService) {
    this.service = courierService;
  }

  @GetMapping(value = "/bigwave/courier")
  public ResponseEntity<List<CourierDto>> getCouriers() {
    List<Courier> couriers = service.getEntities();
    List<CourierDto> couriersDto = createDtos(couriers);
    return new ResponseEntity<>(couriersDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/courier/{courierId}")
  public ResponseEntity<CourierDto> getCourier(@PathVariable Integer courierId) {
    Courier courier = service.getEntity(courierId);
    CourierDto courierDto = createDto(courier);
    return new ResponseEntity<>(courierDto, HttpStatus.OK);
  }

  @PostMapping(value = "/bigwave/courier")
  public ResponseEntity<CourierDto> setCourier(@RequestBody Courier courier) {
    Courier newCourier = service.createEntity(courier);
    CourierDto courierDto = createDto(newCourier);
    return new ResponseEntity<>(courierDto, HttpStatus.OK);
  }

  @PutMapping(value = "/bigwave/courier/{courierId}")
  public ResponseEntity<CourierDto> updateCourier(
          @RequestBody Courier courier, @PathVariable Integer courierId) {
    Courier newCourier = service.updateEntity(courier, courierId);
    CourierDto courierDto = createDto(newCourier);
    return new ResponseEntity<>(courierDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bigwave/courier/{courierId}")
  public ResponseEntity<Courier> deleteCourier(@PathVariable Integer courierId) {
    service.deleteEntity(courierId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/courier/name/{nameId}")
  public ResponseEntity<List<CourierDto>> getCouriersByName(
          @PathVariable Integer nameId) {
    Set<Courier> couriers = service.getCouriersByNameId(nameId);
    List<CourierDto> couriersDto = createDtos(couriers);
    return new ResponseEntity<>(couriersDto, HttpStatus.OK);
  }

  @Override
  public List<CourierDto> createDtos(Iterable<Courier> couriers) {
    List<CourierDto> couriersDto = new ArrayList<>();
    for (Courier courier : couriers) {
      CourierDto courierDto = new CourierDto(courier);
      couriersDto.add(courierDto);
    }
    return couriersDto;
  }

  @Override
  public CourierDto createDto(Courier courier) {
    return new CourierDto(courier);
  }
}
