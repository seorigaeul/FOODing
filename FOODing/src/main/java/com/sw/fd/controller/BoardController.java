package com.sw.fd.controller;

import com.sw.fd.dto.GroupDTO;
import com.sw.fd.dto.MemberGroupDTO;
import com.sw.fd.entity.Board;
import com.sw.fd.entity.Member;
import com.sw.fd.entity.MemberGroup;
import com.sw.fd.service.BoardService;
import com.sw.fd.service.GroupService;
import com.sw.fd.service.MemberGroupService;
import com.sw.fd.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class BoardController {
    @Autowired
    private GroupService groupService;

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String showBoard(HttpServletRequest request, Model model) {
        String gnumber = request.getParameter("gno");


        if (gnumber != null) {
            try{
                int gno = Integer.parseInt(gnumber);
                
                GroupDTO group = groupService.getGroupById(gno);
                int bno = gno;
                List<Board> board = boardService.getBoardByBno(bno);
                
                if (group != null) {
                    model.addAttribute("board", board);
                }else{
                    model.addAttribute("error", "찾을 수 없는 모임");
                }
            } catch (NumberFormatException e) {
                model.addAttribute("error", e.getMessage());
            }
        }else {
            model.addAttribute("error", "모임 번호가 없음");
        }

        int gBoard = Integer.parseInt(gnumber);
        List<Board> board = boardService.getBoardByGroupGno(gBoard);

        model.addAttribute("board", board);
        return "board";
    }
}
