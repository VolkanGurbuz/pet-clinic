package com.volkangurbuz.petclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {
  // anything that is a many relationship is going to be lazily initialized. when eager is set, jpa
  // is going to set all once, the default one does not load
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "vet_specialties",
      joinColumns = @JoinColumn(name = "vet_id"),
      inverseJoinColumns = @JoinColumn(name = "speciality_id"))
  private Set<Speciality> specialitySet = new HashSet<>();

  public Set<Speciality> getSpecialitySet() {
    return specialitySet;
  }

  public void setSpecialitySet(Set<Speciality> specialitySet) {
    this.specialitySet = specialitySet;
  }
}
