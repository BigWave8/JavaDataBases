package com.oryshchak.repository;

import com.oryshchak.model.ParcelOnWay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelOnWayRepository extends JpaRepository<ParcelOnWay, Integer> {
}
