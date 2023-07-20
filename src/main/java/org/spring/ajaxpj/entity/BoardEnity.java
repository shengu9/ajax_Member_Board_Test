package org.spring.ajaxpj.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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

  // 기본 필수 시간
  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createTime; // 글작성일

  @UpdateTimestamp
  @Column(insertable = false)
  private LocalDateTime updateTime;//글 수정일

  // 게시글 아이디를 이용해서 아이디에 해당하는 회원의 정보를 알수 있다.
  //연관 관계
  @ManyToOne
  @JoinColumn(name ="member_id") // 1  PK 참조
  private MemberEntity memberEntity;  // PK 테이블(Entity)

}
