package com.oryshchak.businesslogic.model;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.PrimaryKey;
import com.oryshchak.businesslogic.model.annotations.Table;

@Table(name = "password")
public class Password {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;

  @Column(name = "password", length = 20)
  private String password;

  public Password() {
  }

  public Password(Integer id, String password) {
    this.id = id;
    this.password = password;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Password password = (Password) o;

    if (!id.equals(password.id)) {
      return false;
    }
    return this.password.equals(password.password);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + password.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return String.format("%3s   %-20s", id, password);
  }
}
