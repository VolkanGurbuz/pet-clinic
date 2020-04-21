package com.volkangurbuz.petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
  @Column(name = "date")
  private LocalDate localDate;

  @Column(name = "description")
  private String desciption;

  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;

  public LocalDate getLocalDate() {
    return localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public String getDesciption() {
    return desciption;
  }

  public void setDesciption(String desciption) {
    this.desciption = desciption;
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }
}
