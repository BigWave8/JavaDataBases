package com.oryshchak.service;

import com.oryshchak.model.Courier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CourierService extends GeneralService<Courier, Integer> {

  Set<Courier> getCouriersByNameId(Integer nameId);
}
