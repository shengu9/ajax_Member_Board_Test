package org.spring.ajaxpj.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.ajaxpj.entity.BoardEnity;
import org.spring.ajaxpj.entity.MemberEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

  private Long id;

  private String tilte;

  private String content;

  private String writer;

  private LocalDateTime createTime; // 글작성일

  private LocalDateTime updateTime;//글 수정일

  private MemberEntity memberEntity;  // PK 테이블(Entity)


  public static BoardDto toBoardDtoList(BoardEnity boardEnity){
    BoardDto boardDto=new BoardDto();
    boardDto.setId(boardEnity.getId());
    boardDto.setTilte(boardEnity.getTilte());
    boardDto.setContent(boardEnity.getContent());
    boardDto.setWriter(boardEnity.getWriter());
    boardDto.setMemberEntity(boardEnity.getMemberEntity());
    boardDto.setCreateTime(boardEnity.getCreateTime());
    return boardDto;
  }


}
