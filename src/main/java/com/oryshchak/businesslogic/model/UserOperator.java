package com.oryshchak.businesslogic.model;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.PrimaryKey;
import com.oryshchak.businesslogic.model.annotations.Table;

@Table(name = "user_operator")
public class UserOperator {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;

  @Column(name = "user_id", type = "int")
  private Integer userId;

  @Column(name = "operator_id", type = "int")
  private Integer operatorId;

  public UserOperator() {
  }

  public UserOperator(Integer id, Integer userId, Integer operatorId) {
    this.id = id;
    this.userId = userId;
    this.operatorId = operatorId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getOperatorId() {
    return operatorId;
  }

  public void setOperatorId(Integer operatorId) {
    this.operatorId = operatorId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserOperator that = (UserOperator) o;

    if (!id.equals(that.id)) {
      return false;
    }
    if (!userId.equals(that.userId)) {
      return false;
    }
    return operatorId.equals(that.operatorId);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + userId.hashCode();
    result = 31 * result + operatorId.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return String.format("%3s   %-7s %-5s", id, userId, operatorId);
  }
}
