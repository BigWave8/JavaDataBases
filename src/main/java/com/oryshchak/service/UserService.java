package com.oryshchak.service;

import com.oryshchak.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

@Service
public interface UserService extends GeneralService<User, Integer> {

  Set<User> getUsersByAdressId(Integer adressId);

  Set<User> getUsersByNameId(Integer nameId);

  Set<User> getUsersByOperatorId(Integer operatorId);

  @Transactional
  User setUserToOperator(Integer userId, Integer operatorId);

  @Transactional
  User updateUserToOperator(Integer userId, Integer operatorId);

  @Transactional
  User deleteUserToOperator(Integer userId, Integer operatorId);


}
