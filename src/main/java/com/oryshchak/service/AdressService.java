package com.oryshchak.service;

import com.oryshchak.model.Adress;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface AdressService extends GeneralService<Adress, Integer> {

  Set<Adress> getAdressesByCityId(Integer cityId);
}
