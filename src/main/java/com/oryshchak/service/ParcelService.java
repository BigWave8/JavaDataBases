package com.oryshchak.service;

import com.oryshchak.model.Parcel;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface ParcelService extends GeneralService<Parcel, String> {

  Set<Parcel> getParcelsBySenderId(Integer userId);

  Set<Parcel> getParcelsByRecepientId(Integer userId);

  Set<Parcel> getParcelsBySenderDepartmentId(Integer departmentId);

  Set<Parcel> getParcelsByRecepientDepartmentId(Integer departmentId);

  Set<Parcel> getParcelsByParcelOnWayId(Integer parcelOnWayId);
}
