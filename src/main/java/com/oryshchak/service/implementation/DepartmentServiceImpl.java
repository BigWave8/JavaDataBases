package com.oryshchak.service.implementation;

import com.oryshchak.exceptions.NoSuchDepartmentException;
import com.oryshchak.model.Adress;
import com.oryshchak.model.Department;
import com.oryshchak.repository.AdressRepository;
import com.oryshchak.repository.DepartmentRepository;
import com.oryshchak.service.DepartmentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  DepartmentRepository departmentRepository;
  AdressRepository adressRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository,
                               AdressRepository adressRepository) {
    this.departmentRepository = departmentRepository;
    this.adressRepository = adressRepository;
  }

  @Override
  public List<Department> getEntities() {
    return departmentRepository.findAll();
  }

  @Override
  public Department getEntity(Integer entityId) {
    if (departmentRepository.existsById(entityId)) {
      return departmentRepository.findById(entityId).get();
    }
    throw new NoSuchDepartmentException();
  }

  @Override
  public Department createEntity(Department entity) {
    return departmentRepository.save(entity);
  }

  @Override
  public Department updateEntity(Department entity, Integer entityId) {
    if (departmentRepository.existsById(entityId)) {
      Department department = departmentRepository.findById(entityId).get();
      return departmentRepository.save(mergeEntities(department, entity));
    }
    throw new NoSuchDepartmentException();
  }

  @Override
  public Department mergeEntities(Department newEntity, Department entity) {
    newEntity.setIndex(entity.getIndex() != null ? entity.getIndex() : newEntity.getIndex());
    newEntity.setAdressByAdressId(entity.getAdressByAdressId() != null
            ? entity.getAdressByAdressId() : newEntity.getAdressByAdressId());

    return newEntity;
  }

  @Override
  public void deleteEntity(Integer entityId) {
    if (departmentRepository.existsById(entityId)) {
      departmentRepository.deleteById(entityId);
      return;
    }
    throw new NoSuchDepartmentException();
  }

  public Set<Department> getDepartmentsByAdressId(Integer adressId) {
    if (adressRepository.existsById(adressId)) {
      Adress adress = adressRepository.findById(adressId).get();
      return adress.getDepartments();
    }
    throw new NoSuchDepartmentException();
  }
}
