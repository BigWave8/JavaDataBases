package com.oryshchak.controller.implementation;

import com.oryshchak.controller.ControllerWithDto;
import com.oryshchak.dto.ParcelOnWayDto;
import com.oryshchak.model.ParcelOnWay;
import com.oryshchak.service.ParcelOnWayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class ParcelOnWayController implements ControllerWithDto<ParcelOnWayDto, ParcelOnWay> {

  private final ParcelOnWayService service;

  public ParcelOnWayController(ParcelOnWayService parcelOnWayService) {
    this.service = parcelOnWayService;
  }

  @GetMapping(value = "/bigwave/parcelOnWay")
  public ResponseEntity<List<ParcelOnWayDto>> getParcelOnWays() {
    List<ParcelOnWay> parcelOnWays = service.getEntities();
    List<ParcelOnWayDto> parcelOnWaysDto = createDtos(parcelOnWays);
    return new ResponseEntity<>(parcelOnWaysDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/parcelOnWay/{parcelOnWayId}")
  public ResponseEntity<ParcelOnWayDto> getParcelOnWay(@PathVariable Integer parcelOnWayId) {
    ParcelOnWay parcelOnWay = service.getEntity(parcelOnWayId);
    ParcelOnWayDto parcelOnWayDto = createDto(parcelOnWay);
    return new ResponseEntity<>(parcelOnWayDto, HttpStatus.OK);
  }

  @PostMapping(value = "/bigwave/parcelOnWay")
  public ResponseEntity<ParcelOnWayDto> setParcelOnWay(@RequestBody ParcelOnWay parcelOnWay) {
    ParcelOnWay newParcelOnWay = service.createEntity(parcelOnWay);
    ParcelOnWayDto parcelOnWayDto = createDto(newParcelOnWay);
    return new ResponseEntity<>(parcelOnWayDto, HttpStatus.OK);
  }

  @PutMapping(value = "/bigwave/parcelOnWay/{parcelOnWayId}")
  public ResponseEntity<ParcelOnWayDto> updateParcelOnWay(
          @RequestBody ParcelOnWay parcelOnWay, @PathVariable Integer parcelOnWayId) {
    ParcelOnWay newParcelOnWay = service.updateEntity(parcelOnWay, parcelOnWayId);
    ParcelOnWayDto parcelOnWayDto = createDto(newParcelOnWay);
    return new ResponseEntity<>(parcelOnWayDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bigwave/parcelOnWay/{parcelOnWayId}")
  public ResponseEntity<ParcelOnWay> deleteParcelOnWay(@PathVariable Integer parcelOnWayId) {
    service.deleteEntity(parcelOnWayId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/parcelOnWay/courier/{courierId}")
  public ResponseEntity<List<ParcelOnWayDto>> getParcelOnWaysByCourier(
          @PathVariable Integer courierId) {
    Set<ParcelOnWay> parcelOnWays = service.getParcelOnWaysByCourierId(courierId);
    List<ParcelOnWayDto> parcelOnWaysDto = createDtos(parcelOnWays);
    return new ResponseEntity<>(parcelOnWaysDto, HttpStatus.OK);
  }

  @Override
  public List<ParcelOnWayDto> createDtos(Iterable<ParcelOnWay> parcelOnWays) {
    List<ParcelOnWayDto> parcelOnWaysDto = new ArrayList<>();
    for (ParcelOnWay parcelOnWay : parcelOnWays) {
      ParcelOnWayDto parcelOnWayDto = new ParcelOnWayDto(parcelOnWay);
      parcelOnWaysDto.add(parcelOnWayDto);
    }
    return parcelOnWaysDto;
  }

  @Override
  public ParcelOnWayDto createDto(ParcelOnWay parcelOnWay) {
    return new ParcelOnWayDto(parcelOnWay);
  }
}
