package com.oryshchak.service.implementation;

import com.oryshchak.exceptions.NoSuchParcelException;
import com.oryshchak.model.Department;
import com.oryshchak.model.Parcel;
import com.oryshchak.model.ParcelOnWay;
import com.oryshchak.model.User;
import com.oryshchak.repository.DepartmentRepository;
import com.oryshchak.repository.ParcelOnWayRepository;
import com.oryshchak.repository.ParcelRepository;
import com.oryshchak.repository.UserRepository;
import com.oryshchak.service.ParcelService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class ParcelServiceImpl implements ParcelService {

  ParcelRepository parcelRepository;
  UserRepository userRepository;
  DepartmentRepository departmentRepository;
  ParcelOnWayRepository parcelOnWayRepository;

  public ParcelServiceImpl(ParcelRepository parcelRepository,
                           UserRepository userRepository,
                           DepartmentRepository departmentRepository,
                           ParcelOnWayRepository parcelOnWayRepository) {
    this.parcelRepository = parcelRepository;
    this.userRepository = userRepository;
    this.departmentRepository = departmentRepository;
    this.parcelOnWayRepository = parcelOnWayRepository;
  }

  @Override
  public List<Parcel> getEntities() {
    return parcelRepository.findAll();
  }

  @Override
  public Parcel getEntity(String entityId) {
    if (parcelRepository.existsById(entityId)) {
      return parcelRepository.findById(entityId).get();
    }
    throw new NoSuchParcelException();
  }

  @Override
  public Parcel createEntity(Parcel entity) {
    return parcelRepository.save(entity);
  }

  @Override
  public Parcel updateEntity(Parcel entity, String entityId) {
    if (parcelRepository.existsById(entityId)) {
      Parcel parcel = parcelRepository.findById(entityId).get();
      return parcelRepository.save(mergeEntities(parcel, entity));
    }
    throw new NoSuchParcelException();
  }

  @Override
  public Parcel mergeEntities(Parcel newEntity, Parcel entity) {
    newEntity.setCategory(entity.getCategory() != null
            ? entity.getCategory() : newEntity.getCategory());
    newEntity.setMassInKilogram(entity.getMassInKilogram() != null
            ? entity.getMassInKilogram() : newEntity.getMassInKilogram());
    newEntity.setFragility(entity.getFragility() != null
            ? entity.getFragility() : newEntity.getFragility());
    newEntity.setDateOfReceiving(entity.getDateOfReceiving() != null
            ? entity.getDateOfReceiving() : newEntity.getDateOfReceiving());
    newEntity.setUserBySenderId(entity.getUserBySenderId() != null
            ? entity.getUserBySenderId() : newEntity.getUserBySenderId());
    newEntity.setUserByRecepientId(entity.getUserByRecepientId() != null
            ? entity.getUserByRecepientId() : newEntity.getUserByRecepientId());
    newEntity.setDepartmentBySenderId(entity.getDepartmentBySenderId() != null
            ? entity.getDepartmentBySenderId() : newEntity.getDepartmentBySenderId());
    newEntity.setDepartmentByRecepientId(entity.getDepartmentByRecepientId() != null
            ? entity.getDepartmentByRecepientId() : newEntity.getDepartmentByRecepientId());
    newEntity.setParcelOnWayByRouteNumberId(entity.getParcelOnWayByRouteNumberId() != null
            ? entity.getParcelOnWayByRouteNumberId() : newEntity.getParcelOnWayByRouteNumberId());

    return newEntity;
  }

  @Override
  public void deleteEntity(String entityId) {
    if (parcelRepository.existsById(entityId)) {
      parcelRepository.deleteById(entityId);
      return;
    }
    throw new NoSuchParcelException();
  }

  public Set<Parcel> getParcelsBySenderId(Integer userId) {
    if (userRepository.existsById(userId)) {
      User user = userRepository.findById(userId).get();
      return user.getSenders();
    }
    throw new NoSuchParcelException();
  }

  public Set<Parcel> getParcelsByRecepientId(Integer userId) {
    if (userRepository.existsById(userId)) {
      User user = userRepository.findById(userId).get();
      return user.getRecepients();
    }
    throw new NoSuchParcelException();
  }

  public Set<Parcel> getParcelsBySenderDepartmentId(Integer departmentId) {
    if (departmentRepository.existsById(departmentId)) {
      Department department = departmentRepository.findById(departmentId).get();
      return department.getSenderDepartments();
    }
    throw new NoSuchParcelException();
  }

  public Set<Parcel> getParcelsByRecepientDepartmentId(Integer departmentId) {
    if (departmentRepository.existsById(departmentId)) {
      Department department = departmentRepository.findById(departmentId).get();
      return department.getRecepientDepatments();
    }
    throw new NoSuchParcelException();
  }

  public Set<Parcel> getParcelsByParcelOnWayId(Integer parcelOnWayId) {
    if (parcelOnWayRepository.existsById(parcelOnWayId)) {
      ParcelOnWay parcelOnWay = parcelOnWayRepository.findById(parcelOnWayId).get();
      return parcelOnWay.getParcelOnWayRouterNumbers();
    }
    throw new NoSuchParcelException();
  }
}
