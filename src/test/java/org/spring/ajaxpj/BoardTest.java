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
    boardDto.setTilte("제목2");
    boardDto.setContent("내용2");
    boardDto.setWriter("글쓴이2");

    MemberDto memberDto=new MemberDto();
    memberDto.setId(2L);
    MemberEntity memberEntity
            = MemberEntity.toMemberEntityDelete(memberDto);
    boardDto.setMemberEntity(memberEntity);  // member_id

    BoardEnity boardEnity
            = BoardEnity.toBoardEntityInsert(boardDto);
    boardRepository.save(boardEnity);  // 게시글 작성
  }

  @Test
  void findAll(){
//
//    List<BoardDto> memberDtoList=new ArrayList<>();
//    List<BoardEnity> boardEnityList= boardRepository.findAll();
//    if(!boardEnityList.isEmpty()){
//      // 조회할 목록 O
//      for (BoardEnity boardEnity : boardEnityList) {
//        BoardDto BoardDto = BoardDto
//
//        memberDtoList.add(BoardDto);
//      }
//    }else{
//      // 조회할 목록 X
//    }
//    for(MemberDto memberDto:memberDtoList){
//      System.out.print("id-> " + memberDto.getId());
//      System.out.print(" name-> " + memberDto.getName());
//      System.out.print(" email-> " + memberDto.getEmail());
//      System.out.println("date-> " + memberDto.getCreateTime());
//    }
  }






}
