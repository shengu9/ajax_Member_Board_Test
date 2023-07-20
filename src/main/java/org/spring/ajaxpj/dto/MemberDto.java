package org.spring.ajaxpj.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.ajaxpj.entity.BoardEnity;
import org.spring.ajaxpj.entity.MemberEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

  private Long id;

  private String name;

  private String email;

  private LocalDateTime createTime; // 생성일

  private LocalDateTime updateTime;//수정일

  private List<BoardEnity> boardEnityList;
  //  Entity -> Dto

  public static MemberDto toMemberDto(MemberEntity memberEntity){
    MemberDto memberDto=new MemberDto();
    memberDto.setId(memberEntity.getId());
    memberDto.setName(memberEntity.getName());
    memberDto.setEmail(memberEntity.getEmail());
    memberDto.setCreateTime(memberEntity.getCreateTime());
    return memberDto;
  }















}
