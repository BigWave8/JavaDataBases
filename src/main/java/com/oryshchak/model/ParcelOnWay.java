package com.oryshchak.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parcel_on_way", schema = "oryshchak")
public class ParcelOnWay {
  private Integer id;
  private Courier courierByCourierId;
  private Set<Parcel> parcelOnWayRouterNumbers;

  public static void printHeaders() {
    System.out.format(
            "%n%3s    %-20s%n",
            "id",
            "courierByCourierId");
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

    ParcelOnWay that = (ParcelOnWay) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @ManyToOne
  @JoinColumn(name = "courier_id", referencedColumnName = "id", nullable = false)
  public Courier getCourierByCourierId() {
    return courierByCourierId;
  }

  public void setCourierByCourierId(Courier courierByCourierId) {
    this.courierByCourierId = courierByCourierId;
  }

  @OneToMany(mappedBy = "parcelOnWayByRouteNumberId")
  public Set<Parcel> getParcelOnWayRouterNumbers() {
    return parcelOnWayRouterNumbers;
  }

  public void setParcelOnWayRouterNumbers(Set<Parcel> parcelOnWayRouterNumbers) {
    this.parcelOnWayRouterNumbers = parcelOnWayRouterNumbers;
  }

  @Override
  public String toString() {
    return String.format("%3s    %-20s", id, courierByCourierId.getId());
  }
}
