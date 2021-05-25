package com.oryshchak.service.implementation;

import com.oryshchak.exceptions.AlreadyExistRelationUserOperatorException;
import com.oryshchak.exceptions.NoSuchOperatorException;
import com.oryshchak.exceptions.NoSuchRelationUserOperatorException;
import com.oryshchak.exceptions.NoSuchUserException;
import com.oryshchak.model.Adress;
import com.oryshchak.model.Name;
import com.oryshchak.model.Operator;
import com.oryshchak.model.User;
import com.oryshchak.repository.AdressRepository;
import com.oryshchak.repository.NameRepository;
import com.oryshchak.repository.OperatorRepository;
import com.oryshchak.repository.UserRepository;
import com.oryshchak.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

  UserRepository userRepository;
  AdressRepository adressRepository;
  NameRepository nameRepository;
  OperatorRepository operatorRepository;

  public UserServiceImpl(UserRepository userRepository,
                         AdressRepository adressRepository,
                         NameRepository nameRepository,
                         OperatorRepository operatorRepository) {
    this.userRepository = userRepository;
    this.adressRepository = adressRepository;
    this.nameRepository = nameRepository;
    this.operatorRepository = operatorRepository;
  }

  @Override
  public List<User> getEntities() {
    return userRepository.findAll();
  }

  @Override
  public User getEntity(Integer entityId) {
    if (userRepository.existsById(entityId)) {
      return userRepository.findById(entityId).get();
    }
    throw new NoSuchUserException();
  }

  @Override
  public User createEntity(User entity) {
    return userRepository.save(entity);
  }

  @Override
  public User updateEntity(User entity, Integer entityId) {
    if (userRepository.existsById(entityId)) {
      User user = userRepository.findById(entityId).get();
      return userRepository.save(mergeEntities(user, entity));
    }
    throw new NoSuchUserException();
  }

  @Override
  public User mergeEntities(User newEntity, User entity) {
    newEntity.setPhoneNumber(entity.getPhoneNumber() != null
            ? entity.getPhoneNumber() : newEntity.getPhoneNumber());
    newEntity.setAdressByAdressId(entity.getAdressByAdressId() != null
            ? entity.getAdressByAdressId() : newEntity.getAdressByAdressId());
    newEntity.setNameByNameId(entity.getNameByNameId() != null
            ? entity.getNameByNameId() : newEntity.getNameByNameId());

    return newEntity;
  }

  @Override
  public void deleteEntity(Integer entityId) {
    if (userRepository.existsById(entityId)) {
      userRepository.deleteById(entityId);
      return;
    }
    throw new NoSuchUserException();
  }

  public Set<User> getUsersByAdressId(Integer adressId) {
    if (adressRepository.existsById(adressId)) {
      Adress adress = adressRepository.findById(adressId).get();
      return adress.getUsers();
    }
    throw new NoSuchUserException();
  }

  public Set<User> getUsersByNameId(Integer nameId) {
    if (nameRepository.existsById(nameId)) {
      Name name = nameRepository.findById(nameId).get();
      return name.getUsers();
    }
    throw new NoSuchUserException();
  }

  public Set<User> getUsersByOperatorId(Integer operatorId) {
    if (operatorRepository.existsById(operatorId)) {
      Operator operator = operatorRepository.findById(operatorId).get();
      return operator.getUsers();
    }
    throw new NoSuchUserException();
  }

  @Transactional
  public User setUserToOperator(Integer userId, Integer operatorId) {

    if (!userRepository.existsById(userId)) {
      throw new NoSuchUserException();
    }
    if (!operatorRepository.existsById(operatorId)) {
      throw new NoSuchOperatorException();
    }
    User user = userRepository.findById(userId).get();
    Operator operator = operatorRepository.findById(operatorId).get();

    if (!operator.getUsers().isEmpty()) {
      throw new AlreadyExistRelationUserOperatorException();
    }
    user.getOperators().add(operator);

    return userRepository.save(user);
  }

  @Transactional
  public User updateUserToOperator(Integer userId, Integer operatorId) {

    if (!userRepository.existsById(userId)) {
      throw new NoSuchUserException();
    }
    if (!operatorRepository.existsById(operatorId)) {
      throw new NoSuchOperatorException();
    }
    User user = userRepository.findById(userId).get();
    Operator operator = operatorRepository.findById(operatorId).get();

    if (!operator.getUsers().isEmpty()) {
      throw new NoSuchRelationUserOperatorException();
    }

    for (User tempUser : operator.getUsers()) {
      tempUser.getOperators().remove(user);
      userRepository.saveAndFlush(tempUser);
    }

    user.getOperators().add(operator);

    return userRepository.save(user);
  }

  @Transactional
  public User deleteUserToOperator(Integer userId, Integer operatorId) {

    if (!userRepository.existsById(userId)) {
      throw new NoSuchUserException();
    }
    if (!operatorRepository.existsById(operatorId)) {
      throw new NoSuchOperatorException();
    }

    User user = userRepository.findById(userId).get();
    Operator operator = operatorRepository.findById(operatorId).get();

    if (operator.getUsers().isEmpty()) {
      throw new NoSuchRelationUserOperatorException();
    }
    user.getOperators().remove(operator);

    return userRepository.save(user);
  }
}
