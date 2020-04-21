package com.volkangurbuz.petclinic.services.springdatajpa;

import com.volkangurbuz.petclinic.model.Pet;
import com.volkangurbuz.petclinic.model.PetType;
import com.volkangurbuz.petclinic.model.Vet;
import com.volkangurbuz.petclinic.repositories.PetTypeRepository;
import com.volkangurbuz.petclinic.services.PetService;
import com.volkangurbuz.petclinic.services.PetTypeService;
import com.volkangurbuz.petclinic.services.map.PetServiceMap;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

  private final PetTypeRepository petTypeRepository;

  public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    petTypeRepository.findAll().forEach(petTypes::add);
    return petTypes;
  }

  @Override
  public PetType findById(Long aLong) {
    return petTypeRepository.findById(aLong).orElse(null);
  }

  @Override
  public PetType save(PetType object) {
    return petTypeRepository.save(object);
  }

  @Override
  public void delete(PetType object) {
    petTypeRepository.delete(object);
  }

  @Override
  public void deletById(Long aLong) {
    petTypeRepository.deleteById(aLong);
  }
}
