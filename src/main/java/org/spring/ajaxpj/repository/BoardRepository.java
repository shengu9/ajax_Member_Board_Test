package org.spring.ajaxpj.repository;

import org.spring.ajaxpj.entity.BoardEnity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEnity,Long> {
}
