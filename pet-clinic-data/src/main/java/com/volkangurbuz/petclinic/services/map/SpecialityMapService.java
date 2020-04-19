package com.volkangurbuz.petclinic.services.map;

import com.volkangurbuz.petclinic.model.Speciality;
import com.volkangurbuz.petclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long>
    implements SpecialtyService {
  @Override
  public Set<Speciality> findAll() {
    return super.findAll();
  }

  @Override
  public void deletById(Long aLong) {
    super.deleteById(aLong);
  }

  @Override
  public void delete(Speciality object) {
    super.delete(object);
  }

  @Override
  public Speciality save(Speciality object) {

    return super.save(object);
  }

  @Override
  public Speciality findById(Long id) {
    return super.findById(id);
  }
}
