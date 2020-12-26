package com.oryshchak.service.implementation;

import com.oryshchak.exceptions.NoSuchParcelOnWayException;
import com.oryshchak.model.*;
import com.oryshchak.repository.CourierRepository;
import com.oryshchak.repository.ParcelOnWayRepository;
import com.oryshchak.service.ParcelOnWayService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class ParcelOnWayServiceImpl implements ParcelOnWayService {

  ParcelOnWayRepository parcelOnWayRepository;
  CourierRepository courierRepository;

  public ParcelOnWayServiceImpl(ParcelOnWayRepository parcelOnWayRepository,
                                CourierRepository courierRepository) {
    this.parcelOnWayRepository = parcelOnWayRepository;
    this.courierRepository = courierRepository;
  }

  @Override
  public List<ParcelOnWay> getEntities() {
    return parcelOnWayRepository.findAll();
  }

  @Override
  public ParcelOnWay getEntity(Integer entityId) {
    if (parcelOnWayRepository.existsById(entityId)) {
      return parcelOnWayRepository.findById(entityId).get();
    }
    throw new NoSuchParcelOnWayException();
  }

  @Override
  public ParcelOnWay createEntity(ParcelOnWay entity) {
    return parcelOnWayRepository.save(entity);
  }

  @Override
  public ParcelOnWay updateEntity(ParcelOnWay entity, Integer entityId) {
    if (parcelOnWayRepository.existsById(entityId)) {
      ParcelOnWay parcelOnWay = parcelOnWayRepository.findById(entityId).get();
      return parcelOnWayRepository.save(mergeEntities(parcelOnWay, entity));
    }
    throw new NoSuchParcelOnWayException();
  }

  @Override
  public ParcelOnWay mergeEntities(ParcelOnWay newEntity, ParcelOnWay entity) {
    newEntity.setCourierByCourierId(entity.getCourierByCourierId() != null
            ? entity.getCourierByCourierId() : newEntity.getCourierByCourierId());

    return newEntity;
  }

  @Override
  public void deleteEntity(Integer entityId) {
    if (parcelOnWayRepository.existsById(entityId)) {
      parcelOnWayRepository.deleteById(entityId);
      return;
    }
    throw new NoSuchParcelOnWayException();
  }

  public Set<ParcelOnWay> getParcelOnWaysByCourierId(Integer courierId) {
    if (courierRepository.existsById(courierId)) {
      Courier courier = courierRepository.findById(courierId).get();
      return courier.getParcelOnWays();
    }
    throw new NoSuchParcelOnWayException();
  }
}
