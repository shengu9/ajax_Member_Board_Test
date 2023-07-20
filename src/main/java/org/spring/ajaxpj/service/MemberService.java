package org.spring.ajaxpj.service;

import lombok.RequiredArgsConstructor;
import org.spring.ajaxpj.dto.MemberDto;
import org.spring.ajaxpj.entity.MemberEntity;
import org.spring.ajaxpj.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
  //  @Autowired
//  private MemberRepository memberRepository;
  private final MemberRepository memberRepository;
  public List<MemberDto> memberListDo() {

    List<MemberDto> memberDtoList = new ArrayList<>();

    List<MemberEntity> memberEntityList = memberRepository.findAll();

    if (!memberEntityList.isEmpty()) {
      for (MemberEntity memberEntity : memberEntityList) {
        MemberDto memberDto = MemberDto.toMemberDto(memberEntity);
        memberDtoList.add(memberDto);
      }
      return memberDtoList; // 회원목록 O
    }
    return memberDtoList; // 회원목록 X
  }


}
