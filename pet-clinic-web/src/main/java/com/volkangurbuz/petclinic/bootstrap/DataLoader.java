package com.volkangurbuz.petclinic.bootstrap;

import com.volkangurbuz.petclinic.model.Owner;
import com.volkangurbuz.petclinic.model.Vet;
import com.volkangurbuz.petclinic.services.OwnerService;
import com.volkangurbuz.petclinic.services.VetService;
import com.volkangurbuz.petclinic.services.map.OwnerServiceMap;
import com.volkangurbuz.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;

  public DataLoader() {
    ownerService = new OwnerServiceMap();
    vetService = new VetServiceMap();
  }

  @Override
  public void run(String... args) throws Exception {

    Owner owner1 = new Owner();
    owner1.setId(1L);
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");

    ownerService.save(owner1);

    System.out.println("loaded owners");

    Vet vet = new Vet();
    vet.setId(1L);
    vet.setFirstName("Sam");
    vet.setLastName("Axe");
    vetService.save(vet);

    System.out.println("loaded vets...");
  }
}