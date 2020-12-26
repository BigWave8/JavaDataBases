package com.oryshchak.service;

import com.oryshchak.model.Department;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface DepartmentService extends GeneralService<Department, Integer> {

  Set<Department> getDepartmentsByAdressId(Integer adressId);
}
