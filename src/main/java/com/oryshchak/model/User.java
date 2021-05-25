package com.oryshchak.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user", schema = "oryshchak")
public class User {
  private Integer id;
  private String phoneNumber;
  private Adress adressByAdressId;
  private Name nameByNameId;
  private Set<Operator> operators;
  private Set<Parcel> senders;
  private Set<Parcel> recepients;

  public static void printHeaders() {
    System.out.format(
            "%n%3s    %-12s %-18s %-15s%n",
            "id",
            "phoneNumber",
            "adressByAdressId",
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

  @Basic
  @Column(name = "phone_number")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    User that = (User) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
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

  @ManyToOne
  @JoinColumn(name = "name_id", referencedColumnName = "id", nullable = false)
  public Name getNameByNameId() {
    return nameByNameId;
  }

  public void setNameByNameId(Name nameByNameId) {
    this.nameByNameId = nameByNameId;
  }

  @OneToMany(mappedBy = "userBySenderId")
  public Set<Parcel> getSenders() {
    return senders;
  }

  public void setSenders(Set<Parcel> senders) {
    this.senders = senders;
  }

  @OneToMany(mappedBy = "userByRecepientId")
  public Set<Parcel> getRecepients() {
    return recepients;
  }

  public void setRecepients(Set<Parcel> recepients) {
    this.recepients = recepients;
  }

  @ManyToMany
  @JoinTable(name = "user_operator", joinColumns =
          @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false),
          inverseJoinColumns =
          @JoinColumn(name = "operator_id", referencedColumnName = "id", nullable = false))
  public Set<Operator> getOperators() {
    return operators;
  }

  public void setOperators(Set<Operator> operators) {
    this.operators = operators;
  }

  @Override
  public String toString() {
    return String.format("%3s    %-12s %-18s %-15s",
                    id, phoneNumber, adressByAdressId.getId(), nameByNameId.getId());
  }
}
