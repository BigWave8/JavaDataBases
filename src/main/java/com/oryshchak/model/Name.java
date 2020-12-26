package com.oryshchak.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "name", schema = "oryshchak")
public class Name {
  private Integer id;
  private String name;
  private String surname;
  private String middleName;
  private Set<User> users;
  private Set<Operator> operators;
  private Set<Courier> couriers;

  public static void printHeaders() {
    System.out.format(
            "%n%3s    %-15s %-12s %-15s%n",
            "id",
            "name",
            "surname",
            "middleName");
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Basic
  @Column(name = "middle_name")
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

    Name that = (Name) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }
    if (surname != null ? !surname.equals(that.surname) : that.surname != null) {
      return false;
    }
    if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "nameByNameId")
  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  @OneToMany(mappedBy = "nameByNameId")
  public Set<Operator> getOperators() {
    return operators;
  }

  public void setOperators(Set<Operator> operators) {
    this.operators = operators;
  }

  @OneToMany(mappedBy = "nameByNameId")
  public Set<Courier> getCouriers() {
    return couriers;
  }

  public void setCouriers(Set<Courier> couriers) {
    this.couriers = couriers;
  }

  @Override
  public String toString() {
    return String.format("%3s    %-15s %-12s %-15s", id, name, surname, middleName);
  }
}
