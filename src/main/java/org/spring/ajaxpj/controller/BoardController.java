package org.spring.ajaxpj.controller;

import lombok.RequiredArgsConstructor;
import org.spring.ajaxpj.dto.BoardDto;
import org.spring.ajaxpj.dto.MemberDto;
import org.spring.ajaxpj.repository.BoardRepository;
import org.spring.ajaxpj.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;
  @GetMapping({"","/index"})
  public String board(){
    return "board/index";
  }

  @GetMapping("/boardList")
  public String boardList(Model model){

    List<BoardDto> boardList= boardService.boardListDo();

    if(!boardList.isEmpty()){
      model.addAttribute("boardList",boardList);

    }
    return "board/boardList";
  }

  @GetMapping("/serach")
  public String serach(@RequestParam("content") String content  ,Model model){

    List<BoardDto> boardList=boardService.boardSearch(content);

    if(!boardList.isEmpty()){
      model.addAttribute("boardList",boardList);

    }
    return "board/boardList";
  }











}
