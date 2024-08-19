package com.sw.fd.repository;

import com.sw.fd.entity.Board;
import com.sw.fd.entity.Write;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WriteRepository extends JpaRepository<Write, Integer> {
    List<Write> findByBoardBno(int bno) ;
}
