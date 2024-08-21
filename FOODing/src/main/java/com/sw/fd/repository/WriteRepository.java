package com.sw.fd.repository;

import com.sw.fd.entity.Board;
import com.sw.fd.entity.Write;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WriteRepository extends JpaRepository<Write, Integer> {

    @Query(value = "SELECT * FROM write_t WHERE bno = :bno ORDER BY wno DESC LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Write> findWritesByBoardBnoWithPagination(@Param("bno") int bno, @Param("limit") int limit, @Param("offset") int offset);

    int countByBoardBno(int bno);

}
