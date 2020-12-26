package com.oryshchak.service.implementation;

import com.oryshchak.exceptions.NoSuchCourierException;
import com.oryshchak.exceptions.NoSuchUserException;
import com.oryshchak.model.Courier;
import com.oryshchak.model.Name;
import com.oryshchak.repository.CourierRepository;
import com.oryshchak.repository.NameRepository;
import com.oryshchak.service.CourierService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class CourierServiceImpl implements CourierService {

  CourierRepository courierRepository;
  NameRepository nameRepository;

  public CourierServiceImpl(CourierRepository courierRepository, NameRepository nameRepository) {
    this.courierRepository = courierRepository;
    this.nameRepository = nameRepository;
  }

  @Override
  public List<Courier> getEntities() {
    return courierRepository.findAll();
  }

  @Override
  public Courier getEntity(Integer entityId) {
    if (courierRepository.existsById(entityId)) {
      return courierRepository.findById(entityId).get();
    }
    throw new NoSuchCourierException();
  }

  @Override
  public Courier createEntity(Courier entity) {
    return courierRepository.save(entity);
  }

  @Override
  public Courier updateEntity(Courier entity, Integer entityId) {
    if (courierRepository.existsById(entityId)) {
      Courier courier = courierRepository.findById(entityId).get();
      return courierRepository.save(mergeEntities(courier, entity));
    }
    throw new NoSuchCourierException();
  }

  @Override
  public Courier mergeEntities(Courier newEntity, Courier entity) {
    newEntity.setNameByNameId(entity.getNameByNameId() != null
            ? entity.getNameByNameId() : newEntity.getNameByNameId());

    return newEntity;
  }

  @Override
  public void deleteEntity(Integer entityId) {
    if (courierRepository.existsById(entityId)) {
      courierRepository.deleteById(entityId);
      return;
    }
    throw new NoSuchCourierException();
  }

  public Set<Courier> getCouriersByNameId(Integer nameId) {
    if (nameRepository.existsById(nameId)) {
      Name name = nameRepository.findById(nameId).get();
      return name.getCouriers();
    }
    throw new NoSuchUserException();
  }
}
