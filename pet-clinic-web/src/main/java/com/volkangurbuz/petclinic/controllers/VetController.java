package com.volkangurbuz.petclinic.controllers;

import com.volkangurbuz.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

  private VetService vetService;

  public VetController(VetService vetService) {
    this.vetService = vetService;
  }

  @RequestMapping({"/vets", "vets/index", "/vets/index.html", "/vets.html"})
  public String listVets(Model model) {
    // the folder of index

    model.addAttribute("vets", vetService.findAll());

    return "vets/index";
  }
}
