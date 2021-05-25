package com.oryshchak.controller;

import com.oryshchak.dto.MessageDto;
import com.oryshchak.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExeptionHandlerController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(NoSuchAdressException.class)
  ResponseEntity<MessageDto> handleNoSuchAdressException() {
    return new ResponseEntity<>(
            new MessageDto("Such Adress is not present in database"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoSuchCityException.class)
  ResponseEntity<MessageDto> handleNoSuchCityException() {
    return new ResponseEntity<>(
            new MessageDto("Such City is not present in database"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoSuchCourierException.class)
  ResponseEntity<MessageDto> handleNoSuchCourierException() {
    return new ResponseEntity<>(
            new MessageDto("Such Courier is not present in database"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoSuchDepartmentException.class)
  ResponseEntity<MessageDto> handleNoSuchDepartmentException() {
    return new ResponseEntity<>(
            new MessageDto("Such Department is not present in database"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoSuchNameException.class)
  ResponseEntity<MessageDto> handleNoSuchNameException() {
    return new ResponseEntity<>(
            new MessageDto("Such Name is not present in database"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoSuchOperatorException.class)
  ResponseEntity<MessageDto> handleNoSuchOperatorException() {
    return new ResponseEntity<>(
            new MessageDto("Such Operator is not present in database"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoSuchParcelException.class)
  ResponseEntity<MessageDto> handleNoSuchParcelException() {
    return new ResponseEntity<>(
            new MessageDto("Such Parcel is not present in database"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoSuchParcelOnWayException.class)
  ResponseEntity<MessageDto> handleNoSuchParcelOnWayException() {
    return new ResponseEntity<>(
            new MessageDto("Such ParcelOnWay is not present in database"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoSuchRegionException.class)
  ResponseEntity<MessageDto> handleNoSuchRegionException() {
    return new ResponseEntity<>(
            new MessageDto("Such Region is not present in database"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoSuchUserException.class)
  ResponseEntity<MessageDto> handleNoSuchUserException() {
    return new ResponseEntity<>(
            new MessageDto("Such User is not present in database"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(AlreadyExistRelationUserOperatorException.class)
  ResponseEntity<MessageDto> handleAlreadyExistRelationUserOperatorException() {
    return new ResponseEntity<>(
            new MessageDto("Such Relation User Operator is already present in database"),
            HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoSuchRelationUserOperatorException.class)
  ResponseEntity<MessageDto> handleNoSuchRelationUserOperatorException() {
    return new ResponseEntity<>(
            new MessageDto("Such Relation User Operator is not present in database"),
            HttpStatus.NOT_FOUND);
  }
}
