package org.spring.ajaxpj.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.ajaxpj.dto.BoardDto;

import javax.persistence.*;
import java.time.LocalDateTime;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "board_tb_04")
public class BoardEnity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "board_id")
  private Long id;

  @Column(name = "board_tille",nullable = false)
  private String tilte;

  @Column(name = "board_content",nullable = false)
  private String content;

  @Column(name = "board_writer",nullable = false)
  private String writer;

  // 게시글 아이디를 이용해서 아이디에 해당하는 회원의 정보를 알수 있다.
  //연관 관계
  @ManyToOne
  @JoinColumn(name ="member_id") // 1  PK 참조
  private MemberEntity memberEntity;  // PK 테이블(Entity)
  // 기본 필수 시간
  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createTime; // 글작성일
  @UpdateTimestamp
  @Column(insertable = false)
  private LocalDateTime updateTime;//글 수정일
  //dto-> Entity
  public static BoardEnity toBoardEntityInsert(BoardDto boardDto){
    BoardEnity boardEnity=new BoardEnity();
    boardEnity.setTilte(boardDto.getTilte());
    boardEnity.setContent(boardDto.getContent());
    boardEnity.setWriter(boardDto.getWriter());
    boardEnity.setMemberEntity(boardDto.getMemberEntity());
    return boardEnity;
  }









}
