package org.spring.ajaxpj;

import org.junit.jupiter.api.Test;
import org.spring.ajaxpj.dto.MemberDto;
import org.spring.ajaxpj.entity.MemberEntity;
import org.spring.ajaxpj.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MemberTest {

  @Autowired
  private MemberRepository memberRepository;

  @Test
  void insert() {
    // 회원가입
    MemberDto memberDto = new MemberDto();
//    memberDto.setName("m1");
//    memberDto.setEmail("m1@ga.com");

//    memberDto.setName("m2");
//    memberDto.setEmail("m2@ga.com");
//
//    memberDto.setName("m3");
//    memberDto.setEmail("m3@ga.com");

//    memberDto.setName("m4");
//    memberDto.setEmail("m4@ga.com");

    memberDto.setName("m5");
    memberDto.setEmail("m5@ga.com");

    MemberEntity memberEntity = MemberEntity.toMemberEntityInsert(memberDto);
    memberRepository.save(memberEntity);

//    memberRepository.save(MemberEntity.toMemberInsert(memberDto));

  }

  @Test
  void update() {

    MemberDto memberDto = new MemberDto();
    memberDto.setId(1L);  // id(기본키)
    memberDto.setName("m1_수정");
    memberDto.setEmail("m1@emm.com_수정");//test

//    MemberEntity memberEntity= MemberEntity.toMemberEntiyUpdate(memberDto);
//    memberRepository.save(memberEntity);

    memberRepository.save(MemberEntity.toMemberEntiyUpdate(memberDto));
  }

  @Test
  void delete() {

    MemberDto memberDto = new MemberDto();
    memberDto.setId(1L);

    MemberEntity memberEntity
            = MemberEntity.toMemberEntityDelete(memberDto);
    memberRepository.delete(memberEntity);

//    memberRepository.deleteById(1L);

//    MemberEntity.builder()
//            .id(1L)
//            .build();

//    memberRepository.delete(MemberEntity.builder().id(1L).build());

  }

  @Test
  void findById() {
    MemberDto memberDto = new MemberDto();

    memberDto.setId(1L);
    Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(memberDto.getId());

    if (!optionalMemberEntity.isPresent()) {
      System.out.println("조회할 회원이 없다.");
    } else {
      System.out.println("조회할 회원");
      MemberEntity memberEntity
              = optionalMemberEntity.get();
      //  Entity -> Dto
      MemberDto memberDto1 = MemberDto.toMemberDto(memberEntity);

      System.out.println("id-> " + memberDto1.getId());
      System.out.println("name-> " + memberDto1.getName());
      System.out.println("email-> " + memberDto1.getEmail());
      System.out.println("date-> " + memberDto1.getCreateTime());
    }
  }

  @Test
  void findAll(){
    List<MemberDto> memberDtoList=new ArrayList<>();
    List<MemberEntity> memberEntityList= memberRepository.findAll();
    if(!memberEntityList.isEmpty()){
      // 조회할 목록 O
      for (MemberEntity memberEntity : memberEntityList) {
        // Entity -> Dto  하나씩    memberDtoList.add()
        MemberDto memberDto = MemberDto.toMemberDto(memberEntity);
        memberDtoList.add(memberDto);
      }
    }else{
      // 조회할 목록 X
    }
    for(MemberDto memberDto:memberDtoList){
      System.out.print("id-> " + memberDto.getId());
      System.out.print(" name-> " + memberDto.getName());
      System.out.print(" email-> " + memberDto.getEmail());
      System.out.println("date-> " + memberDto.getCreateTime());
    }













  }

}
