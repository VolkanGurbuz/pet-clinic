package com.volkangurbuz.petclinic.services.map;

import com.volkangurbuz.petclinic.model.Pet;
import com.volkangurbuz.petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Pet object) {}

  @Override
  public Pet save(Pet object) {
    return super.save(object.getId(), object);
  }

  @Override
  public void deletById(Long aLong) {
    super.deleteById(aLong);
  }

  @Override
  public Pet findById(Long id) {
    return super.findById(id);
  }
}
