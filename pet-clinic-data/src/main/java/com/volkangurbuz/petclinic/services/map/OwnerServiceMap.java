package com.volkangurbuz.petclinic.services.map;

import com.volkangurbuz.petclinic.model.Owner;
import com.volkangurbuz.petclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Owner object) {
    super.delete(object);
  }

  @Override
  public Owner save(Owner object) {
    return super.save(object.getId(), object);
  }

  @Override
  public void deletById(Long aLong) {
    this.deleteById(aLong);
  }

  @Override
  public Owner findById(Long id) {
    return this.findById(id);
  }

  @Override
  public Owner findByLastName(String lastName) {
    return null;
  }
}
