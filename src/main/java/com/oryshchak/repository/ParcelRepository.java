package com.oryshchak.repository;

import com.oryshchak.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, String> {
}
