package org.spring.ajaxpj.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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

  // Dto -> Entity


}
