package com.volkangurbuz.petclinic.services;

import com.volkangurbuz.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

  Pet findById(Long id);

  Pet save(Pet pet);

  Set<Pet> findAll();
}
