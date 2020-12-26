package com.oryshchak.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public interface GeneralService<T, ID> {

  List<T> getEntities();

  T getEntity(ID entityId);

  @Transactional
  T createEntity(T entity);

  @Transactional
  T updateEntity(T entity, ID entityId);

  T mergeEntities(T newEntity, T entity);

  @Transactional
  void deleteEntity(ID entityId);
}