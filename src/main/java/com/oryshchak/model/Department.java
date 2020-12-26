package com.oryshchak.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department", schema = "oryshchak")
public class Department {
  private Integer id;
  private Integer index;
  private Adress adressByAdressId;
  private Set<Parcel> senderDepartments;
  private Set<Parcel> recepientDepatments;

  public static void printHeaders() {
    System.out.format(
            "%n%3s    %-7s %-20s%n",
            "id",
            "index",
            "adressByAdressId");
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
  @Column(name = "index")
  public Integer getIndex() {
    return index;
  }

  public void setIndex(Integer index) {
    this.index = index;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Department that = (Department) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (index != null ? !index.equals(that.index) : that.index != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (index != null ? index.hashCode() : 0);
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "adress_id", referencedColumnName = "id", nullable = false)
  public Adress getAdressByAdressId() {
    return adressByAdressId;
  }

  public void setAdressByAdressId(Adress adressByAdressId) {
    this.adressByAdressId = adressByAdressId;
  }

  @OneToMany(mappedBy = "departmentBySenderId")
  public Set<Parcel> getSenderDepartments() {
    return senderDepartments;
  }

  public void setSenderDepartments(Set<Parcel> senderDepartments) {
    this.senderDepartments = senderDepartments;
  }

  @OneToMany(mappedBy = "departmentByRecepientId")
  public Set<Parcel> getRecepientDepatments() {
    return recepientDepatments;
  }

  public void setRecepientDepatments(Set<Parcel> recepientDepatments) {
    this.recepientDepatments = recepientDepatments;
  }

  @Override
  public String toString() {
    return String.format("%3s    %-7s %-20s", id, index, adressByAdressId.getId());
  }
}
