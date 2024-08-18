package com.sw.fd.controller;

import com.sw.fd.dto.MemberGroupDTO;
import com.sw.fd.entity.Member;
import com.sw.fd.entity.MemberGroup;
import com.sw.fd.service.GroupService;
import com.sw.fd.service.MemberGroupService;
import com.sw.fd.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
    @Autowired
    private GroupService groupService;

    @Autowired
    private MemberGroupService memberGroupService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/board")
    public String showBoard(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("loggedInMember");
        if (member == null) {
            return "redirect:/login";
        }

        List<MemberGroupDTO> memberGroups = memberGroupService.getMemberGroupsWithGroup(member);
        for (MemberGroupDTO memberGroup : memberGroups) {
           if (memberGroup == session.getAttribute(member.getMnick())) memberGroup.getGroup().getGname();
        }
        List<Integer> gnos = new ArrayList<>();
        for (MemberGroupDTO memberGroup : memberGroups) {
            gnos.add(memberGroup.getGroup().getGno());
        }
        List<MemberGroup> allMembers = memberService.getMemberGroupsByGnos(gnos);

        List<MemberGroup> leaderList = new ArrayList<>();
        for (MemberGroup memberGroup : allMembers) {
            if (memberGroup.getJauth() == 1) {
                leaderList.add(memberGroup);
            }
        }

        model.addAttribute("leaderList", leaderList);

        return "board";
}
}
