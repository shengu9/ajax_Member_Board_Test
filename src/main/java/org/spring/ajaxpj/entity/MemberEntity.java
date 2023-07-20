package org.spring.ajaxpj.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.ajaxpj.dto.MemberDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member_tb_04")  // 실제 테이블이름
public class MemberEntity { // member_entity

  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
  @Column(name = "member_id")
  private Long id;

  @Column(name = "member_name",nullable = false)
  private String name;

  @Column(name = "member_email",nullable = false,unique = true)
  private String email;

  // 기본 필수 시간
  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createTime; // 생성일

  @UpdateTimestamp
  @Column(insertable = false)
  private LocalDateTime updateTime;//수정일


  //member_id통해 게시글리스트 조회
  //연관 관계  // 연관관계의 주인
  @OneToMany(mappedBy = "memberEntity") //
  private List<BoardEnity> boardEnityList;

  // Dto -> Entity
  //회원등록
  public static MemberEntity toMemberEntityInsert(MemberDto memberDto){
    MemberEntity memberEntity=new MemberEntity();
    memberEntity.setName(memberDto.getName());
    memberEntity.setEmail(memberDto.getEmail());
    return memberEntity;
  }
  //회원수정
  public static MemberEntity toMemberEntiyUpdate(MemberDto memberDto){
    MemberEntity memberEntity=new MemberEntity();
    memberEntity.setId(memberDto.getId());
    memberEntity.setName(memberDto.getName());
    memberEntity.setEmail(memberDto.getEmail());
    return memberEntity;
  }

  // 회원삭제
  public static  MemberEntity toMemberEntityDelete(MemberDto memberDto){
    MemberEntity memberEntity=new MemberEntity();
    memberEntity.setId(memberDto.getId());
    return memberEntity;
  }



}
