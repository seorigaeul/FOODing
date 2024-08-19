package com.sw.fd.controller;

import com.sw.fd.entity.Member;
import com.sw.fd.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class WriteController {
    @Autowired
    private BoardService boardService;

    @GetMapping("write")
    public String showWriteForm(HttpSession session, Model model){
        Member loggedInMember = (Member) session.getAttribute("loggedInMember");

        if(loggedInMember == null){
            return "redirect:/login";
        }else{
            model.addAttribute("member", loggedInMember.getMnick());
            return "write";
        }

    }
}
