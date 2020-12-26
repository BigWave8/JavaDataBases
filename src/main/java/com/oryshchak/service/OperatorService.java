package com.oryshchak.service;

import com.oryshchak.model.Operator;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface OperatorService extends GeneralService<Operator, Integer> {

  Set<Operator> getOperatorsByNameId(Integer nameId);

  Set<Operator> getOperatorsByUserId(Integer userId);

}
