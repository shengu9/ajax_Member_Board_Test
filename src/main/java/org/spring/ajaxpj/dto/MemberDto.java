package org.spring.ajaxpj.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

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

  //  Entity -> Dto

}
