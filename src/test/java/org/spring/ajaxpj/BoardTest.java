package org.spring.ajaxpj;

import org.junit.jupiter.api.Test;
import org.spring.ajaxpj.dto.BoardDto;
import org.spring.ajaxpj.dto.MemberDto;
import org.spring.ajaxpj.entity.BoardEnity;
import org.spring.ajaxpj.entity.MemberEntity;
import org.spring.ajaxpj.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BoardTest {

  @Autowired
  private BoardRepository boardRepository;


  @Test
  void insert(){
    BoardDto boardDto=new BoardDto();
    boardDto.setTilte("제목23");
    boardDto.setContent("내용23");
    boardDto.setWriter("글쓴이23");

    MemberDto memberDto=new MemberDto();
    memberDto.setId(3L);
    MemberEntity memberEntity
            = MemberEntity.toMemberEntityDelete(memberDto);
    boardDto.setMemberEntity(memberEntity);  // member_id

    BoardEnity boardEnity
            = BoardEnity.toBoardEntityInsert(boardDto);
    boardRepository.save(boardEnity);  // 게시글 작성
  }

  @Test
  void findAll(){

    List<BoardDto> boardDtoList=new ArrayList<>();
    List<BoardEnity> boardEnityList= boardRepository.findAll();

    if(!boardEnityList.isEmpty()){
      // 조회할 목록 O
      for (BoardEnity boardEnity : boardEnityList) {
        BoardDto boardDto =BoardDto.toBoardDtoList(boardEnity);
        boardDtoList.add(boardDto);
      }
    }else{
      // 조회할 목록 X
    }
    for(BoardDto boardDto:boardDtoList){
      System.out.print("글번호-> " + boardDto.getId());
      System.out.print(" 제목-> " + boardDto.getTilte());
      System.out.print(" 내용-> " + boardDto.getContent());
      System.out.print(" 작성자-> " + boardDto.getWriter());
      System.out.println(" member_id-> " + boardDto.getMemberEntity().getId());
    }
  }


  @Test
  void boardIdList(){

    List<BoardDto> boardDtoList=new ArrayList<>();

    List<BoardEnity> boardEnityList
            = boardRepository.findByIdList(3L);

    if(!boardEnityList.isEmpty()){
      // 조회할 목록 O
      for (BoardEnity boardEnity : boardEnityList) {
        BoardDto boardDto =BoardDto.toBoardDtoList(boardEnity);
        boardDtoList.add(boardDto);
      }
    }else{
      // 조회할 목록 X
    }
    for(BoardDto boardDto:boardDtoList){
      System.out.print("글번호-> " + boardDto.getId());
      System.out.print(" 제목-> " + boardDto.getTilte());
      System.out.print(" 내용-> " + boardDto.getContent());
      System.out.print(" 작성자-> " + boardDto.getWriter());
      System.out.println(" member_id-> " + boardDto.getMemberEntity().getId());
    }
  }














}
