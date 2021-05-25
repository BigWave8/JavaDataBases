package com.oryshchak.service.implementation;

import com.oryshchak.exceptions.NoSuchNameException;
import com.oryshchak.model.Name;
import com.oryshchak.repository.NameRepository;
import com.oryshchak.service.NameService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NameServiceImpl implements NameService {

  NameRepository nameRepository;

  public NameServiceImpl(NameRepository nameRepository) {
    this.nameRepository = nameRepository;
  }

  @Override
  public List<Name> getEntities() {
    return nameRepository.findAll();
  }

  @Override
  public Name getEntity(Integer entityId) {
    if (nameRepository.existsById(entityId)) {
      return nameRepository.findById(entityId).get();
    }
    throw new NoSuchNameException();
  }

  @Override
  public Name createEntity(Name entity) {
    return nameRepository.save(entity);
  }

  @Override
  public Name updateEntity(Name entity, Integer entityId) {
    if (nameRepository.existsById(entityId)) {
      Name name = nameRepository.findById(entityId).get();
      return nameRepository.save(mergeEntities(name, entity));
    }
    throw new NoSuchNameException();
  }

  @Override
  public Name mergeEntities(Name newEntity, Name entity) {
    newEntity.setName(entity.getName() != null ? entity.getName() : newEntity.getName());
    newEntity.setSurname(entity.getSurname() != null
            ? entity.getSurname() : newEntity.getSurname());
    newEntity.setMiddleName(entity.getMiddleName() != null
            ? entity.getMiddleName() : newEntity.getMiddleName());

    return newEntity;
  }

  @Override
  public void deleteEntity(Integer entityId) {
    if (nameRepository.existsById(entityId)) {
      nameRepository.deleteById(entityId);
      return;
    }
    throw new NoSuchNameException();
  }
}
