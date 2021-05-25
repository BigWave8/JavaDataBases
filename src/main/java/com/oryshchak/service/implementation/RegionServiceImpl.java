package com.oryshchak.service.implementation;

import com.oryshchak.exceptions.NoSuchRegionException;
import com.oryshchak.model.Region;
import com.oryshchak.repository.RegionRepository;
import com.oryshchak.service.RegionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

  RegionRepository regionRepository;

  public RegionServiceImpl(RegionRepository regionRepository) {
    this.regionRepository = regionRepository;
  }

  @Override
  public List<Region> getEntities() {
    return regionRepository.findAll();
  }

  @Override
  public Region getEntity(Integer entityId) {
    if (regionRepository.existsById(entityId)) {
      return regionRepository.findById(entityId).get();
    }
    throw new NoSuchRegionException();
  }

  @Override
  public Region createEntity(Region entity) {
    return regionRepository.save(entity);
  }

  @Override
  public Region updateEntity(Region entity, Integer entityId) {
    if (regionRepository.existsById(entityId)) {
      Region region = regionRepository.findById(entityId).get();
      return regionRepository.save(mergeEntities(region, entity));
    }
    throw new NoSuchRegionException();
  }

  @Override
  public Region mergeEntities(Region newEntity, Region entity) {
    newEntity.setRegion(entity.getRegion() != null ? entity.getRegion() : newEntity.getRegion());

    return newEntity;
  }

  @Override
  public void deleteEntity(Integer entityId) {
    if (regionRepository.existsById(entityId)) {
      regionRepository.deleteById(entityId);
      return;
    }
    throw new NoSuchRegionException();
  }
}
