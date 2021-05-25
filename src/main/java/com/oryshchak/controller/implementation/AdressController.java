package com.oryshchak.controller.implementation;

import com.oryshchak.controller.ControllerWithDto;
import com.oryshchak.dto.AdressDto;
import com.oryshchak.model.Adress;
import com.oryshchak.service.AdressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class AdressController implements ControllerWithDto<AdressDto, Adress> {

  private final AdressService service;

  public AdressController(AdressService adressService) {
    this.service = adressService;
  }

  @GetMapping(value = "/bigwave/adress")
  public ResponseEntity<List<AdressDto>> getAdresses() {
    List<Adress> adresses = service.getEntities();
    List<AdressDto> adressesDto = createDtos(adresses);
    return new ResponseEntity<>(adressesDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/adress/{adressId}")
  public ResponseEntity<AdressDto> getAdress(@PathVariable Integer adressId) {
    Adress adress = service.getEntity(adressId);
    AdressDto adressDto = createDto(adress);
    return new ResponseEntity<>(adressDto, HttpStatus.OK);
  }

  @PostMapping(value = "/bigwave/adress")
  public ResponseEntity<AdressDto> setAdress(@RequestBody Adress adress) {
    Adress newAdress = service.createEntity(adress);
    AdressDto adressDto = createDto(newAdress);
    return new ResponseEntity<>(adressDto, HttpStatus.OK);
  }

  @PutMapping(value = "/bigwave/adress/{adressId}")
  public ResponseEntity<AdressDto> updateAdress(
          @RequestBody Adress adress, @PathVariable Integer adressId) {
    Adress newAdress = service.updateEntity(adress, adressId);
    AdressDto adressDto = createDto(newAdress);
    return new ResponseEntity<>(adressDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bigwave/adress/{adressId}")
  public ResponseEntity<Adress> deleteAdress(@PathVariable Integer adressId) {
    service.deleteEntity(adressId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/adress/city/{cityId}")
  public ResponseEntity<List<AdressDto>> getAdressesByCity(
          @PathVariable Integer cityId) {
    Set<Adress> adresses = service.getAdressesByCityId(cityId);
    List<AdressDto> adressesDto = createDtos(adresses);
    return new ResponseEntity<>(adressesDto, HttpStatus.OK);
  }

  @Override
  public List<AdressDto> createDtos(Iterable<Adress> adresses) {
    List<AdressDto> adressesDto = new ArrayList<>();
    for (Adress adress : adresses) {
      AdressDto adressDto = new AdressDto(adress);
      adressesDto.add(adressDto);
    }
    return adressesDto;
  }

  @Override
  public AdressDto createDto(Adress adress) {
    return new AdressDto(adress);
  }
}
