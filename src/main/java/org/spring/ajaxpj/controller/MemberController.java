package org.spring.ajaxpj.controller;

import lombok.RequiredArgsConstructor;
import org.spring.ajaxpj.dto.MemberDto;
import org.spring.ajaxpj.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member")  //   /member ~~
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/index")
  public String member(){
    return "member/index"; //  /member/index.html
  }

  @GetMapping("/memberList")
  public String memberList(Model model){

    List<MemberDto> memberList= memberService.memberListDo();

    if(!memberList.isEmpty()){
        model.addAttribute("memberList",memberList);

    }
    return "member/memberList";
  }






}
