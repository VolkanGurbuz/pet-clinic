package com.volkangurbuz.petclinic.repositories;

import com.volkangurbuz.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
