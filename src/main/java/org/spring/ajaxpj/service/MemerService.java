package org.spring.ajaxpj.service;

import lombok.RequiredArgsConstructor;
import org.spring.ajaxpj.dto.MemberDto;
import org.spring.ajaxpj.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemerService {
//  @Autowired
//  private MemberRepository memberRepository;
  private final MemberRepository memberRepository;

}
