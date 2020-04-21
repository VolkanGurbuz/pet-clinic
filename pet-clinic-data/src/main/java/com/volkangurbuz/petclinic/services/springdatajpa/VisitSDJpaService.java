package com.volkangurbuz.petclinic.services.springdatajpa;

import com.volkangurbuz.petclinic.model.Visit;
import com.volkangurbuz.petclinic.repositories.VisitRepository;
import com.volkangurbuz.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

  private final VisitRepository visitRepostory;

  public VisitSDJpaService(VisitRepository visitRepostory) {
    this.visitRepostory = visitRepostory;
  }

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet<>();
    visitRepostory.findAll().forEach(visits::add);
    return visits;
  }

  @Override
  public Visit findById(Long aLong) {
    return visitRepostory.findById(aLong).orElse(null);
  }

  @Override
  public Visit save(Visit object) {
    return visitRepostory.save(object);
  }

  @Override
  public void delete(Visit object) {
    visitRepostory.delete(object);
  }

  @Override
  public void deletById(Long aLong) {
    visitRepostory.deleteById(aLong);
  }
}
