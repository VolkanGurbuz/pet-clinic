package com.volkangurbuz.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  // all paramaters will be match this request mapping
  @RequestMapping({"", "/", "index.html"})
  public String index() {

    return "index";
  }
}
