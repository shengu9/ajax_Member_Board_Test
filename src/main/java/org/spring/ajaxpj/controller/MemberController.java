package org.spring.ajaxpj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")  //   /member ~~
public class MemberController {

  @GetMapping("/index")
  public String member(){
    return "member/index"; //  /member/index.html
  }
}
