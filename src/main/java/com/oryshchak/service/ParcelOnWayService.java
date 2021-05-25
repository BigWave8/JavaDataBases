package com.oryshchak.service;

import com.oryshchak.model.ParcelOnWay;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface ParcelOnWayService extends GeneralService<ParcelOnWay, Integer> {

  Set<ParcelOnWay> getParcelOnWaysByCourierId(Integer courierId);
}
