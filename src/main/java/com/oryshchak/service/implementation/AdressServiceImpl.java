package com.oryshchak.service.implementation;

import com.oryshchak.exceptions.NoSuchAdressException;
import com.oryshchak.model.Adress;
import com.oryshchak.model.City;
import com.oryshchak.repository.AdressRepository;
import com.oryshchak.repository.CityRepository;
import com.oryshchak.service.AdressService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class AdressServiceImpl implements AdressService {

  AdressRepository adressRepository;
  CityRepository cityRepository;

  public AdressServiceImpl(AdressRepository adressRepository, CityRepository cityRepository) {
    this.adressRepository = adressRepository;
    this.cityRepository = cityRepository;
  }

  @Override
  public List<Adress> getEntities() {
    return adressRepository.findAll();
  }

  @Override
  public Adress getEntity(Integer entityId) {
    if (adressRepository.existsById(entityId)) {
      return adressRepository.findById(entityId).get();
    }
    throw new NoSuchAdressException();
  }

  @Override
  public Adress createEntity(Adress entity) {
    return adressRepository.save(entity);
  }

  @Override
  public Adress updateEntity(Adress entity, Integer entityId) {
    if (adressRepository.existsById(entityId)) {
      Adress adress = adressRepository.findById(entityId).get();
      return adressRepository.save(mergeEntities(adress, entity));
    }
    throw new NoSuchAdressException();
  }

  @Override
  public Adress mergeEntities(Adress newEntity, Adress entity) {
    newEntity.setStreet(entity.getStreet() != null ? entity.getStreet() : newEntity.getStreet());
    newEntity.setHouseNumber(
            entity.getHouseNumber() != null ? entity.getHouseNumber() : newEntity.getHouseNumber());
    newEntity.setApartmentNumber(entity.getApartmentNumber() != null
            ? entity.getApartmentNumber() : newEntity.getApartmentNumber());
    newEntity.setIndex(entity.getIndex() != null ? entity.getIndex() : newEntity.getIndex());
    newEntity.setCityByCityId(entity.getCityByCityId() != null
            ? entity.getCityByCityId() : newEntity.getCityByCityId());

    return newEntity;
  }

  @Override
  public void deleteEntity(Integer entityId) {
    if (adressRepository.existsById(entityId)) {
      adressRepository.deleteById(entityId);
      return;
    }
    throw new NoSuchAdressException();
  }

  public Set<Adress> getAdressesByCityId(Integer cityId) {
    if (cityRepository.existsById(cityId)) {
      City city = cityRepository.findById(cityId).get();
      return city.getAdresses();
    }
    throw new NoSuchAdressException();
  }
}