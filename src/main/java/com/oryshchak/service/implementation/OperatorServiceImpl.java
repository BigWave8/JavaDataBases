package com.oryshchak.service.implementation;

import com.oryshchak.exceptions.NoSuchOperatorException;
import com.oryshchak.model.Name;
import com.oryshchak.model.Operator;
import com.oryshchak.model.User;
import com.oryshchak.repository.NameRepository;
import com.oryshchak.repository.OperatorRepository;
import com.oryshchak.repository.UserRepository;
import com.oryshchak.service.OperatorService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class OperatorServiceImpl implements OperatorService {

  OperatorRepository operatorRepository;
  NameRepository nameRepository;
  UserRepository userRepository;

  public OperatorServiceImpl(OperatorRepository operatorRepository,
                             NameRepository nameRepository,
                             UserRepository userRepository) {
    this.operatorRepository = operatorRepository;
    this.nameRepository = nameRepository;
    this.userRepository = userRepository;
  }

  @Override
  public List<Operator> getEntities() {
    return operatorRepository.findAll();
  }

  @Override
  public Operator getEntity(Integer entityId) {
    if (operatorRepository.existsById(entityId)) {
      return operatorRepository.findById(entityId).get();
    }
    throw new NoSuchOperatorException();
  }

  @Override
  public Operator createEntity(Operator entity) {
    return operatorRepository.save(entity);
  }

  @Override
  public Operator updateEntity(Operator entity, Integer entityId) {
    if (operatorRepository.existsById(entityId)) {
      Operator operator = operatorRepository.findById(entityId).get();
      return operatorRepository.save(mergeEntities(operator, entity));
    }
    throw new NoSuchOperatorException();
  }

  @Override
  public Operator mergeEntities(Operator newEntity, Operator entity) {
    newEntity.setNameByNameId(entity.getNameByNameId() != null
            ? entity.getNameByNameId() : newEntity.getNameByNameId());

    return newEntity;
  }

  @Override
  public void deleteEntity(Integer entityId) {
    if (operatorRepository.existsById(entityId)) {
      operatorRepository.deleteById(entityId);
      return;
    }
    throw new NoSuchOperatorException();
  }

  public Set<Operator> getOperatorsByNameId(Integer nameId) {
    if (nameRepository.existsById(nameId)) {
      Name name = nameRepository.findById(nameId).get();
      return name.getOperators();
    }
    throw new NoSuchOperatorException();
  }

  public Set<Operator> getOperatorsByUserId(Integer userId) {
    if (userRepository.existsById(userId)) {
      User user = userRepository.findById(userId).get();
      return user.getOperators();
    }
    throw new NoSuchOperatorException();
  }
}
