package com.oryshchak.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "operator", schema = "oryshchak")
public class Operator {
  private Integer id;
  private Name nameByNameId;
  private Set<User> users;

  public static void printHeaders() {
    System.out.format(
            "%n%3s    %-20s%n",
            "id",
            "nameByNameId");
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Operator that = (Operator) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @ManyToOne
  @JoinColumn(name = "name_id", referencedColumnName = "id", nullable = false)
  public Name getNameByNameId() {
    return nameByNameId;
  }

  public void setNameByNameId(Name nameByNameId) {
    this.nameByNameId = nameByNameId;
  }

  @ManyToMany
  @JoinTable(name = "user_operator", schema = "oryshchak",
          joinColumns = @JoinColumn(name = "operator_id",
                  referencedColumnName = "id", nullable = false),
          inverseJoinColumns = @JoinColumn(name = "user_id",
                  referencedColumnName = "id", nullable = false))
  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return String.format("%3s    %-20s", id, nameByNameId.getId());
  }
}
