package com.volkangurbuz.petclinic.repositories;

import com.volkangurbuz.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepostory extends CrudRepository<Visit, Long> {
}
