package com.volkangurbuz.petclinic.services.springdatajpa;

import com.volkangurbuz.petclinic.model.Vet;
import com.volkangurbuz.petclinic.repositories.OwnerRepository;
import com.volkangurbuz.petclinic.repositories.PetRepository;
import com.volkangurbuz.petclinic.repositories.PetTypeRepository;
import com.volkangurbuz.petclinic.repositories.VetRepository;
import com.volkangurbuz.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

  private final VetRepository vetRepository;

  public VetSDJpaService(VetRepository vetRepository) {
    this.vetRepository = vetRepository;
  }

  @Override
  public Set<Vet> findAll() {
    Set<Vet> vets = new HashSet<>();
    vetRepository.findAll().forEach(vets::add);
    return vets;
  }

  @Override
  public Vet findById(Long aLong) {
    return vetRepository.findById(aLong).orElse(null);
  }

  @Override
  public Vet save(Vet object) {
    return vetRepository.save(object);
  }

  @Override
  public void delete(Vet object) {
    vetRepository.delete(object);
  }

  @Override
  public void deletById(Long aLong) {
    vetRepository.deleteById(aLong);
  }
}
