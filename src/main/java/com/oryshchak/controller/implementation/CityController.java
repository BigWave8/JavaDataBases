package com.oryshchak.controller.implementation;

import com.oryshchak.controller.ControllerWithDto;
import com.oryshchak.dto.CityDto;
import com.oryshchak.model.City;
import com.oryshchak.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class CityController implements ControllerWithDto<CityDto, City> {

  private final CityService service;

  public CityController(CityService cityService) {
    this.service = cityService;
  }

  @GetMapping(value = "/bigwave/city")
  public ResponseEntity<List<CityDto>> getCities() {
    List<City> cities = service.getEntities();
    List<CityDto> citiesDto = createDtos(cities);
    return new ResponseEntity<>(citiesDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/city/{cityId}")
  public ResponseEntity<CityDto> getCity(@PathVariable Integer cityId) {
    City adress = service.getEntity(cityId);
    CityDto adressDto = createDto(adress);
    return new ResponseEntity<>(adressDto, HttpStatus.OK);
  }

  @PostMapping(value = "/bigwave/city")
  public ResponseEntity<CityDto> setCity(@RequestBody City city) {
    City newCity = service.createEntity(city);
    CityDto cityDto = createDto(newCity);
    return new ResponseEntity<>(cityDto, HttpStatus.OK);
  }

  @PutMapping(value = "/bigwave/city/{cityId}")
  public ResponseEntity<CityDto> updateCity(
          @RequestBody City city, @PathVariable Integer cityId) {
    City newCity = service.updateEntity(city, cityId);
    CityDto cityDto = createDto(newCity);
    return new ResponseEntity<>(cityDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bigwave/city/{cityId}")
  public ResponseEntity<City> deleteCity(@PathVariable Integer cityId) {
    service.deleteEntity(cityId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/city/region/{regionId}")
  public ResponseEntity<List<CityDto>> getCitiesByRegion(
          @PathVariable Integer regionId) {
    Set<City> cities = service.getCitiesByRegionId(regionId);
    List<CityDto> citiesDto = createDtos(cities);
    return new ResponseEntity<>(citiesDto, HttpStatus.OK);
  }

  @Override
  public List<CityDto> createDtos(Iterable<City> cities) {
    List<CityDto> citiesDto = new ArrayList<>();
    for (City city : cities) {
      CityDto cityDto = new CityDto(city);
      citiesDto.add(cityDto);
    }
    return citiesDto;
  }

  @Override
  public CityDto createDto(City city) {
    return new CityDto(city);
  }
}
