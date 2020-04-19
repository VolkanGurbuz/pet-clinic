package com.volkangurbuz.petclinic.bootstrap;

import com.volkangurbuz.petclinic.model.*;
import com.volkangurbuz.petclinic.services.OwnerService;
import com.volkangurbuz.petclinic.services.PetTypeService;
import com.volkangurbuz.petclinic.services.SpecialtyService;
import com.volkangurbuz.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialtyService specialityService;

  public DataLoader(
      OwnerService ownerService,
      VetService vetService,
      PetTypeService petTypeService,
      SpecialtyService specialityService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialityService = specialityService;
  }

  @Override
  public void run(String... args) throws Exception {

    int count = petTypeService.findAll().size();

    if (count == 0) loadData();
  }

  private void loadData() {
    PetType dog = new PetType();
    dog.setName("Dog");

    PetType savedDogType = petTypeService.save(dog);
    PetType cat = new PetType();
    dog.setName("Cat");
    PetType savedCatType = petTypeService.save(cat);

    Speciality radiology = new Speciality();
    radiology.setDescription("Radiology");
    Speciality savedRadiology = specialityService.save(radiology);

    Speciality surgery = new Speciality();
    radiology.setDescription("Surgery");
    Speciality savedSurgery = specialityService.save(surgery);

    Speciality dentistry = new Speciality();
    radiology.setDescription("Dentistry");
    Speciality savedDentistry = specialityService.save(dentistry);

    Owner owner1 = new Owner();
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");
    owner1.setAddress("greizer strasse");
    owner1.setCity("gera");
    owner1.setTelephone("234234234");

    ownerService.save(owner1);

    Pet michaeLCats = new Pet();
    michaeLCats.setPetType(savedCatType);
    michaeLCats.setOwner(owner1);
    michaeLCats.setBirthDate(LocalDate.now());
    michaeLCats.setName("Rosco");
    owner1.getPets().add(michaeLCats);

    System.out.println("loaded owners");

    Vet vet = new Vet();
    vet.setFirstName("Sam");
    vet.setLastName("Axe");
    vet.getSpecialitySet().add(savedRadiology);
    vetService.save(vet);

    Vet vet2 = new Vet();
    vet2.setFirstName("John");
    vet2.setLastName("Axe");
    vet.getSpecialitySet().add(savedDentistry);
    vetService.save(vet2);

    System.out.println("loaded vets...");
  }
}
