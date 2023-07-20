package org.spring.ajaxpj.service;

import lombok.RequiredArgsConstructor;
import org.spring.ajaxpj.dto.BoardDto;
import org.spring.ajaxpj.dto.MemberDto;
import org.spring.ajaxpj.entity.BoardEnity;
import org.spring.ajaxpj.entity.MemberEntity;
import org.spring.ajaxpj.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;
  public List<BoardDto> boardListDo() {

    List<BoardDto> boardDtoList = new ArrayList<>();
    List<BoardEnity> boardEnityList = boardRepository.findAll();

    if (!boardEnityList.isEmpty()) {

      for (BoardEnity boardEnity : boardEnityList) {
        BoardDto  boardDto = BoardDto.toBoardDtoList(boardEnity);
        boardDtoList.add(boardDto);
      }
      return boardDtoList; // 게시글목록 O
    }
    return boardDtoList; // 게시글목록 X
  }

  public List<BoardDto> boardSearch(String content) {

    List<BoardDto> boardDtoList = new ArrayList<>();
    List<BoardEnity> boardEnityList = boardRepository.findByContentContaining(content);

    if (!boardEnityList.isEmpty()) {

      for (BoardEnity boardEnity : boardEnityList) {
        BoardDto  boardDto = BoardDto.toBoardDtoList(boardEnity);
        boardDtoList.add(boardDto);
      }
      return boardDtoList; // 게시글목록 O
    }
    return boardDtoList; // 게시글목록 X


  }
}
