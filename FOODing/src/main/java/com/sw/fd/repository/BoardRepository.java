package com.sw.fd.repository;

import com.sw.fd.entity.Board;
import com.sw.fd.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board, Integer> {

    List<Board> findByGroupGno(int gno);

    List<Board> findByBno(int bno);
}
