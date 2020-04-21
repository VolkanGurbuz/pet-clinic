package com.volkangurbuz.petclinic.services.map;

import com.volkangurbuz.petclinic.model.Speciality;
import com.volkangurbuz.petclinic.model.Vet;
import com.volkangurbuz.petclinic.services.SpecialtyService;
import com.volkangurbuz.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialtyService specialtyService;

  public VetMapService(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Vet object) {
    super.delete(object);
  }

  @Override
  public Vet save(Vet object) {

    if (object.getSpecialitySet().size() > 0) {
      object
          .getSpecialitySet()
          .forEach(
              speciality -> {
                if (speciality.getId() == null) {
                  Speciality savedSpecialy = specialtyService.save(speciality);
                  speciality.setId(savedSpecialy.getId());
                }
              });
    }
    return super.save(object);
  }

  @Override
  public void deletById(Long aLong) {
    super.deleteById(aLong);
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }
}
