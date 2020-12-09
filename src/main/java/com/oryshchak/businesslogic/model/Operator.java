package com.oryshchak.businesslogic.model;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.PrimaryKey;
import com.oryshchak.businesslogic.model.annotations.Table;

@Table(name = "name")
public class Operator {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;

  @Column(name = "name_id", type = "int")
  private Integer nameId;

  public Operator() {
  }

  public Operator(Integer id, Integer nameId) {
    this.id = id;
    this.nameId = nameId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getNameId() {
    return nameId;
  }

  public void setNameId(Integer nameId) {
    this.nameId = nameId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Operator operator = (Operator) o;

    if (!id.equals(operator.id)) {
      return false;
    }
    return nameId.equals(operator.nameId);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + nameId.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return String.format("%3s   %-7s", id, nameId);
  }
}
