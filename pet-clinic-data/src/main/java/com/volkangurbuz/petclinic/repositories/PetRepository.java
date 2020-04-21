package com.volkangurbuz.petclinic.repositories;

import com.volkangurbuz.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
