package org.spring.ajaxpj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller   // View
public class MainController {

  @GetMapping({"","/index"})   // a, 주소,get
  public String index(){

    // templates/ index .html
    return "index";//
  }
}
