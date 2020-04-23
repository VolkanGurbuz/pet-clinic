package com.volkangurbuz.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
