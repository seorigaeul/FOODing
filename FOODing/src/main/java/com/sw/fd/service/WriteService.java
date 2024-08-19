package com.sw.fd.service;

import com.sw.fd.entity.Board;
import com.sw.fd.entity.Write;
import com.sw.fd.repository.WriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriteService {
    @Autowired
    private WriteRepository writeRepository;

    public List<Write> getWriteByBoardBno(int bno) {
        return writeRepository.findByBoardBno(bno);
    }
}
