package com.volkangurbuz.petclinic.bootstrap;

import com.volkangurbuz.petclinic.model.Owner;
import com.volkangurbuz.petclinic.model.Pet;
import com.volkangurbuz.petclinic.model.PetType;
import com.volkangurbuz.petclinic.model.Vet;
import com.volkangurbuz.petclinic.services.OwnerService;
import com.volkangurbuz.petclinic.services.PetTypeService;
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

  public DataLoader(
      OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
  }

  @Override
  public void run(String... args) throws Exception {

    PetType dog = new PetType();
    dog.setName("Dog");

    PetType savedDogType = petTypeService.save(dog);

    PetType cat = new PetType();
    dog.setName("Cat");

    PetType savedCatType = petTypeService.save(cat);

    Owner owner1 = new Owner();
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");
    owner1.setAddress("greizer strasse");
    owner1.setCity("gera");
    owner1.setTelephone("234234234");

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
    vetService.save(vet);

    System.out.println("loaded vets...");
  }
}
