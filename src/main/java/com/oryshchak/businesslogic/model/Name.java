package com.oryshchak.businesslogic.model;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.PrimaryKey;
import com.oryshchak.businesslogic.model.annotations.Table;

@Table(name = "name")
public class Name {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;

  @Column(name = "name", length = 20)
  private String name;

  @Column(name = "surname", length = 20)
  private String surname;

  @Column(name = "middle_name", length = 20)
  private String middleName;

  public Name() {
  }

  public Name(Integer id, String name, String surname, String middleName) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.middleName = middleName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Name name1 = (Name) o;

    if (!id.equals(name1.id)) {
      return false;
    }
    if (!name.equals(name1.name)) {
      return false;
    }
    if (!surname.equals(name1.surname)) {
      return false;
    }
    return middleName != null ? middleName.equals(name1.middleName) : name1.middleName == null;
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + surname.hashCode();
    result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return String.format("%3s   %-20s %-20s %-20s", id, name, surname, middleName);
  }
}
