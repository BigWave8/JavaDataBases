package com.oryshchak.controller.implementation;

import com.oryshchak.controller.ControllerWithDto;
import com.oryshchak.dto.NameDto;
import com.oryshchak.model.Name;
import com.oryshchak.service.NameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NameController implements ControllerWithDto<NameDto, Name> {

  private final NameService service;

  public NameController(NameService nameService) {
    this.service = nameService;
  }

  @GetMapping(value = "/bigwave/name")
  public ResponseEntity<List<NameDto>> getNames() {
    List<Name> names = service.getEntities();
    List<NameDto> namesDto = createDtos(names);
    return new ResponseEntity<>(namesDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/name/{nameId}")
  public ResponseEntity<NameDto> getName(@PathVariable Integer nameId) {
    Name name = service.getEntity(nameId);
    NameDto nameDto = createDto(name);
    return new ResponseEntity<>(nameDto, HttpStatus.OK);
  }

  @PostMapping(value = "/bigwave/name")
  public ResponseEntity<NameDto> setName(@RequestBody Name name) {
    Name newName = service.createEntity(name);
    NameDto nameDto = createDto(newName);
    return new ResponseEntity<>(nameDto, HttpStatus.OK);
  }

  @PutMapping(value = "/bigwave/name/{nameId}")
  public ResponseEntity<NameDto> updateName(
          @RequestBody Name name, @PathVariable Integer nameId) {
    Name newName = service.updateEntity(name, nameId);
    NameDto nameDto = createDto(newName);
    return new ResponseEntity<>(nameDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bigwave/name/{nameId}")
  public ResponseEntity<Name> deleteName(@PathVariable Integer nameId) {
    service.deleteEntity(nameId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public List<NameDto> createDtos(Iterable<Name> names) {
    List<NameDto> namesDto = new ArrayList<>();
    for (Name name : names) {
      NameDto nameDto = new NameDto(name);
      namesDto.add(nameDto);
    }
    return namesDto;
  }

  @Override
  public NameDto createDto(Name name) {
    return new NameDto(name);
  }
}
