package com.oryshchak.model;

import javax.persistence.*;

@Entity
@Table(name = "courier", schema = "oryshchak")
public class Courier {
  private Integer id;
  private Name nameByNameId;

  public static void printHeaders() {
    System.out.format(
            "%n%3s    %12s%n",
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

    Courier that = (Courier) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }

    return true;
  }

  @ManyToOne
  @JoinColumn(name = "name_id", referencedColumnName = "id", nullable = false)
  public Name getNameByNameId() {
    return nameByNameId;
  }

  public void setNameByNameId(Name nameByNameId) {
    this.nameByNameId = nameByNameId;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return String.format("%3s    %-12s", id, nameByNameId.getId());
  }
}
