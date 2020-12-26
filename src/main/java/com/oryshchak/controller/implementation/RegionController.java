package com.oryshchak.controller.implementation;

import com.oryshchak.controller.ControllerWithDto;
import com.oryshchak.dto.RegionDto;
import com.oryshchak.model.Region;
import com.oryshchak.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RegionController implements ControllerWithDto<RegionDto, Region> {

  private final RegionService service;

  public RegionController(RegionService regionService) {
    this.service = regionService;
  }

  @GetMapping(value = "/bigwave/region")
  public ResponseEntity<List<RegionDto>> getRegions() {
    List<Region> regions = service.getEntities();
    List<RegionDto> regionsDto = createDtos(regions);
    return new ResponseEntity<>(regionsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/region/{regionId}")
  public ResponseEntity<RegionDto> getRegion(@PathVariable Integer regionId) {
    Region region = service.getEntity(regionId);
    RegionDto regionDto = createDto(region);
    return new ResponseEntity<>(regionDto, HttpStatus.OK);
  }

  @PostMapping(value = "/bigwave/region")
  public ResponseEntity<RegionDto> setRegion(@RequestBody Region region) {
    Region newRegion = service.createEntity(region);
    RegionDto regionDto = createDto(newRegion);
    return new ResponseEntity<>(regionDto, HttpStatus.OK);
  }

  @PutMapping(value = "/bigwave/region/{regionId}")
  public ResponseEntity<RegionDto> updateRegion(
          @RequestBody Region region, @PathVariable Integer regionId) {
    Region newRegion = service.updateEntity(region, regionId);
    RegionDto regionDto = createDto(newRegion);
    return new ResponseEntity<>(regionDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bigwave/region/{regionId}")
  public ResponseEntity<Region> deleteRegion(@PathVariable Integer regionId) {
    service.deleteEntity(regionId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public List<RegionDto> createDtos(Iterable<Region> regions) {
    List<RegionDto> regionsDto = new ArrayList<>();
    for (Region region : regions) {
      RegionDto regionDto = new RegionDto(region);
      regionsDto.add(regionDto);
    }
    return regionsDto;
  }

  @Override
  public RegionDto createDto(Region region) {
    return new RegionDto(region);
  }
}
