package com.oryshchak.controller.implementation;

import com.oryshchak.controller.ControllerWithDto;
import com.oryshchak.dto.ParcelDto;
import com.oryshchak.model.Parcel;
import com.oryshchak.service.ParcelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class ParcelController implements ControllerWithDto<ParcelDto, Parcel> {

  private final ParcelService service;

  public ParcelController(ParcelService parcelService) {
    this.service = parcelService;
  }

  @GetMapping(value = "/bigwave/parcel")
  public ResponseEntity<List<ParcelDto>> getParcels() {
    List<Parcel> parcels = service.getEntities();
    List<ParcelDto> parcelsDto = createDtos(parcels);
    return new ResponseEntity<>(parcelsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/parcel/{parcelId}")
  public ResponseEntity<ParcelDto> getParcel(@PathVariable String parcelId) {
    Parcel parcel = service.getEntity(parcelId);
    ParcelDto parcelDto = createDto(parcel);
    return new ResponseEntity<>(parcelDto, HttpStatus.OK);
  }

  @PostMapping(value = "/bigwave/parcel")
  public ResponseEntity<ParcelDto> setParcel(@RequestBody Parcel parcel) {
    Parcel newParcel = service.createEntity(parcel);
    ParcelDto parcelDto = createDto(newParcel);
    return new ResponseEntity<>(parcelDto, HttpStatus.OK);
  }

  @PutMapping(value = "/bigwave/parcel/{parcelId}")
  public ResponseEntity<ParcelDto> updateParcel(
          @RequestBody Parcel parcel, @PathVariable String parcelId) {
    Parcel newParcel = service.updateEntity(parcel, parcelId);
    ParcelDto parcelDto = createDto(newParcel);
    return new ResponseEntity<>(parcelDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bigwave/parcel/{parcelId}")
  public ResponseEntity<Parcel> deleteParcel(@PathVariable String parcelId) {
    service.deleteEntity(parcelId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/parcel/sender/{userId}")
  public ResponseEntity<List<ParcelDto>> getParcelsBySender(
          @PathVariable Integer userId) {
    Set<Parcel> parcels = service.getParcelsBySenderId(userId);
    List<ParcelDto> parcelsDto = createDtos(parcels);
    return new ResponseEntity<>(parcelsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/parcel/recepient/{userId}")
  public ResponseEntity<List<ParcelDto>> getParcelsByRecepient(
          @PathVariable Integer userId) {
    Set<Parcel> parcels = service.getParcelsByRecepientId(userId);
    List<ParcelDto> parcelsDto = createDtos(parcels);
    return new ResponseEntity<>(parcelsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/parcel/department-sender/{departmentId}")
  public ResponseEntity<List<ParcelDto>> getParcelsBySenderDepartment(
          @PathVariable Integer departmentId) {
    Set<Parcel> parcels = service.getParcelsBySenderDepartmentId(departmentId);
    List<ParcelDto> parcelsDto = createDtos(parcels);
    return new ResponseEntity<>(parcelsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/parcel/department-recepient/{departmentId}")
  public ResponseEntity<List<ParcelDto>> getParcelsByRecepientDepartment(
          @PathVariable Integer departmentId) {
    Set<Parcel> parcels = service.getParcelsByRecepientDepartmentId(departmentId);
    List<ParcelDto> parcelsDto = createDtos(parcels);
    return new ResponseEntity<>(parcelsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/parcel/parcel-on-way/{parcelOnWayId}")
  public ResponseEntity<List<ParcelDto>> getParcelsByParcelOnWay(
          @PathVariable Integer parcelOnWayId) {
    Set<Parcel> parcels = service.getParcelsByParcelOnWayId(parcelOnWayId);
    List<ParcelDto> parcelsDto = createDtos(parcels);
    return new ResponseEntity<>(parcelsDto, HttpStatus.OK);
  }

  @Override
  public List<ParcelDto> createDtos(Iterable<Parcel> parcels) {
    List<ParcelDto> parcelsDto = new ArrayList<>();
    for (Parcel parcel : parcels) {
      ParcelDto parcelDto = new ParcelDto(parcel);
      parcelsDto.add(parcelDto);
    }
    return parcelsDto;
  }

  @Override
  public ParcelDto createDto(Parcel parcel) {
    return new ParcelDto(parcel);
  }
}
