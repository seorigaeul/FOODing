package com.sw.fd.service;

import com.sw.fd.entity.Board;
import com.sw.fd.entity.Write;
import com.sw.fd.repository.WriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class WriteService {
    @Autowired
    private WriteRepository writeRepository;

    public List<Write> getWriteByBoardBno(int bno) {
        List<Write> writeList = writeRepository.findByBoardBno(bno);
        for (Write write : writeList) {
            write.setDateToString(write.getWdate().format(DateTimeFormatter.ofPattern("yy-MM-dd")));
        }
        return writeList;
    }

    public Write saveWrite(Write write) {
        write.setWdate(LocalDateTime.now());
        return writeRepository.save(write);
    }
}
