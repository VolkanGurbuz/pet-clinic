package com.volkangurbuz.petclinic.services.map;

import com.volkangurbuz.petclinic.model.Owner;
import com.volkangurbuz.petclinic.model.Visit;
import com.volkangurbuz.petclinic.services.OwnerService;
import com.volkangurbuz.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public void deletById(Long aLong) {
    super.deleteById(aLong);
  }

  @Override
  public void delete(Visit object) {
    super.delete(object);
  }

  @Override
  public Visit save(Visit visit) {

    if (visit.getPet() == null
        || visit.getPet().getOwner() == null
        || visit.getPet().getId() == null
        || visit.getPet().getOwner().getId() == null) {
      throw new RuntimeException("INvalid Visit");
    }
    return super.save(visit);
  }

  @Override
  public Visit findById(Long id) {
    return super.findById(id);
  }
}
