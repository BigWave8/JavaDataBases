package com.oryshchak.controller.implementation;

import com.oryshchak.controller.ControllerWithDto;
import com.oryshchak.dto.UserDto;
import com.oryshchak.model.User;
import com.oryshchak.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class UserController implements ControllerWithDto<UserDto, User> {

  private final UserService service;

  public UserController(UserService userService) {
    this.service = userService;
  }

  @GetMapping(value = "/bigwave/user")
  public ResponseEntity<List<UserDto>> getUsers() {
    List<User> users = service.getEntities();
    List<UserDto> usersDto = createDtos(users);
    return new ResponseEntity<>(usersDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/user/{userId}")
  public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {
    User user = service.getEntity(userId);
    UserDto userDto = createDto(user);
    return new ResponseEntity<>(userDto, HttpStatus.OK);
  }

  @PostMapping(value = "/bigwave/user")
  public ResponseEntity<UserDto> setUser(@RequestBody User user) {
    User newUser = service.createEntity(user);
    UserDto userDto = createDto(newUser);
    return new ResponseEntity<>(userDto, HttpStatus.OK);
  }

  @PutMapping(value = "/bigwave/user/{userId}")
  public ResponseEntity<UserDto> updateUser(
          @RequestBody User user, @PathVariable Integer userId) {
    User newUser = service.updateEntity(user, userId);
    UserDto userDto = createDto(newUser);
    return new ResponseEntity<>(userDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bigwave/user/{userId}")
  public ResponseEntity<User> deleteUser(@PathVariable Integer userId) {
    service.deleteEntity(userId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/user/adress/{adressId}")
  public ResponseEntity<List<UserDto>> getUsersByAdress(
          @PathVariable Integer adressId) {
    Set<User> users = service.getUsersByAdressId(adressId);
    List<UserDto> usersDto = createDtos(users);
    return new ResponseEntity<>(usersDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/user/name/{nameId}")
  public ResponseEntity<List<UserDto>> getUsersByName(
          @PathVariable Integer nameId) {
    Set<User> users = service.getUsersByNameId(nameId);
    List<UserDto> usersDto = createDtos(users);
    return new ResponseEntity<>(usersDto, HttpStatus.OK);
  }

  @GetMapping(value = "/bigwave/user/operator/{operatorId}")
  public ResponseEntity<List<UserDto>> getUsersByOperator(
          @PathVariable Integer operatorId) {
    Set<User> users = service.getUsersByOperatorId(operatorId);
    List<UserDto> usersDto = createDtos(users);
    return new ResponseEntity<>(usersDto, HttpStatus.OK);
  }

  @PostMapping(value = "/bigwave/user/{userId}/operator/{operatorId}")
  public ResponseEntity<UserDto> setUserToOperator(
          @PathVariable Integer userId, @PathVariable Integer operatorId) {
    User user = service.setUserToOperator(userId, operatorId);
    UserDto userDto = createDto(user);
    return new ResponseEntity<>(userDto, HttpStatus.OK);
  }

  @PutMapping(value = "/bigwave/user/{userId}/operator/{operatorId}")
  public ResponseEntity<UserDto> updateUserToOperator(
          @PathVariable Integer userId, @PathVariable Integer operatorId) {
    User user = service.updateUserToOperator(userId, operatorId);
    UserDto userDto = createDto(user);
    return new ResponseEntity<>(userDto, HttpStatus.OK);
  }

  @DeleteMapping(value = "/bigwave/user/{userId}/operator/{operatorId}")
  public ResponseEntity<UserDto> deleteUserToOperator(
          @PathVariable Integer userId, @PathVariable Integer operatorId) {
    User user = service.deleteUserToOperator(userId, operatorId);
    UserDto userDto = createDto(user);
    return new ResponseEntity<>(userDto, HttpStatus.OK);
  }

  @Override
  public List<UserDto> createDtos(Iterable<User> users) {
    List<UserDto> usersDto = new ArrayList<>();
    for (User user : users) {
      UserDto userDto = new UserDto(user);
      usersDto.add(userDto);
    }
    return usersDto;
  }

  @Override
  public UserDto createDto(User user) {
    return new UserDto(user);
  }
}
