package org.spring.ajaxpj.repository;

import org.spring.ajaxpj.entity.BoardEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEnity, Long> {

  @Query(value = "select b.* " +
          "from member_tb_04  m inner join board_tb_04  b " +
          "on m.member_id=b.member_id " +
          "where b.member_id=:id ", nativeQuery = true)
  List<BoardEnity> findByIdList(@Param("id") long id);

}
