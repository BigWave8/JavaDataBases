package com.oryshchak.service.implementation;

import com.oryshchak.exceptions.NoSuchCityException;
import com.oryshchak.model.City;
import com.oryshchak.model.Region;
import com.oryshchak.repository.CityRepository;
import com.oryshchak.repository.RegionRepository;
import com.oryshchak.service.CityService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class CityServiceImpl implements CityService {

  CityRepository cityRepository;
  RegionRepository regionRepository;

  public CityServiceImpl(CityRepository cityRepository, RegionRepository regionRepository) {
    this.cityRepository = cityRepository;
    this.regionRepository = regionRepository;
  }

  @Override
  public List<City> getEntities() {
    return cityRepository.findAll();
  }

  @Override
  public City getEntity(Integer entityId) {
    if (cityRepository.existsById(entityId)) {
      return cityRepository.findById(entityId).get();
    }
    throw new NoSuchCityException();
  }

  @Override
  public City createEntity(City entity) {
    return cityRepository.save(entity);
  }

  @Override
  public City updateEntity(City entity, Integer entityId) {
    if (cityRepository.existsById(entityId)) {
      City city = cityRepository.findById(entityId).get();
      return cityRepository.save(mergeEntities(city, entity));
    }
    throw new NoSuchCityException();
  }

  @Override
  public City mergeEntities(City newEntity, City entity) {
    newEntity.setCity(entity.getCity() != null ? entity.getCity() : newEntity.getCity());
    newEntity.setRegionByRegionId(entity.getRegionByRegionId() != null
            ? entity.getRegionByRegionId() : newEntity.getRegionByRegionId());

    return newEntity;
  }

  @Override
  public void deleteEntity(Integer entityId) {
    if (cityRepository.existsById(entityId)) {
      cityRepository.deleteById(entityId);
      return;
    }
    throw new NoSuchCityException();
  }

  public Set<City> getCitiesByRegionId(Integer regionId) {
    if (regionRepository.existsById(regionId)) {
      Region region = regionRepository.findById(regionId).get();
      return region.getCities();
    }
    throw new NoSuchCityException();
  }
}
