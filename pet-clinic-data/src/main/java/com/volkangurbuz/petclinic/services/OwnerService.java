package com.volkangurbuz.petclinic.services;

import com.volkangurbuz.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);
}
