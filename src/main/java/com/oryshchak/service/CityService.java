package com.oryshchak.service;

import com.oryshchak.model.City;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface CityService extends GeneralService<City, Integer> {

  Set<City> getCitiesByRegionId(Integer regionId);
}
