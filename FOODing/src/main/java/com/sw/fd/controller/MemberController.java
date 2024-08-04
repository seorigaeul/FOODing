package com.sw.fd.controller;

import com.sw.fd.entity.Business;
import com.sw.fd.entity.Member;
import com.sw.fd.repository.MemberRepository;
import com.sw.fd.service.ApiService;
import com.sw.fd.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ApiService apiService;

    @GetMapping("/registerSelect")
    public String selectRegister() {
        return "registerSelect";
    }

    @GetMapping("/register/user")
    public String showUserForm(Model model) {
        Member member = new Member();
        member.setMtype(0); // 손님 (일반회원)으로 설정
        model.addAttribute("member", member);
        model.addAttribute("memberType", "손님");
        return "registerUser";
    }

    @GetMapping("/register/owner")
    public String showOwnerForm(Model model) {
        Member member = new Member();
        member.setMtype(1); // 사장님으로 설정
        model.addAttribute("member", member);
        model.addAttribute("memberType", "사장님");

        return "registerOwner";
    }

    @PostMapping("/register/user")
    public String registerUser(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("memberType", "손님");
            return "registerUser";
        }

        // 아이디 중복 체크
        if (memberService.isMidExists(member.getMid())) {
            bindingResult.rejectValue("mid", "error.member", "이미 사용 중인 아이디입니다.");
            model.addAttribute("memberType", "손님");
            return "registerUser";
        }

        // 닉네임 중복 체크
        if (memberService.isMnickExists(member.getMnick())) {
            bindingResult.rejectValue("mnick", "error.member", "이미 사용 중인 닉네임입니다.");
            model.addAttribute("memberType", "손님");
            return "registerUser";
        }

        memberService.saveMember(member);
        model.addAttribute("message", "일반 회원 가입 성공! 환영합니다!");
        return "login";
    }

    @PostMapping("/register/owner")
    public String registerOwner(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("memberType", "사장님");
            return "registerOwner";
        }

        // 아이디 중복 체크
        if (memberService.isMidExists(member.getMid())) {
            bindingResult.rejectValue("mid", "error.member", "이미 사용 중인 아이디입니다.");
            model.addAttribute("memberType", "사장님");
            return "registerOwner";
        }

        // 닉네임 중복 체크
        if (memberService.isMnickExists(member.getMnick())) {
            bindingResult.rejectValue("mnick", "error.member", "이미 사용 중인 닉네임입니다.");
            model.addAttribute("memberType", "사장님");
            return "registerOwner";
        }

        memberService.saveMember(member);
        model.addAttribute("message", "사장님 회원 가입 성공! 환영합니다!");
        return "login";
    }

    // 사업자등록조회
    @GetMapping("/checkBusiness")
    public String showForm(Model model) {
        model.addAttribute("business", new Business());
        return "checkOwner";
    }

    @PostMapping("/checkBusiness")
    public String checkBusiness(@ModelAttribute("business") Business business, Model model) {
        if (business.getB_no() == null || business.getB_no().isEmpty() ||
                business.getStart_dt() == null || business.getStart_dt().isEmpty() ||
                business.getP_nm() == null || business.getP_nm().isEmpty()) {
            model.addAttribute("message", "모든 필드를 입력해 주세요.");
            model.addAttribute("messageType", "error");
            return "checkOwner";
        }

        String result = apiService.checkBusiness(business);
        if (result.contains("\"valid\":\"01\"")) {
            model.addAttribute("message", "인증되었습니다.");
            model.addAttribute("messageType", "success");
            model.addAttribute("disabled", true);
        } else {
            model.addAttribute("message", "없는 정보입니다. 다시 입력해 주세요.");
            model.addAttribute("messageType", "error");
            model.addAttribute("disabled", true);
        }

        return "checkOwner";
    }

    // 회원 정보 조회
    @GetMapping("/member/view")
    public String viewMember(HttpSession session, Model model) {
        Member loggedInMember = (Member) session.getAttribute("loggedInMember");
        if (loggedInMember == null) {
            model.addAttribute("error", "회원 정보를 찾을 수 없습니다.");
            return "errorPage";
        } else {
            model.addAttribute("member", loggedInMember);
            return "viewMember";
        }
    }

    // 회원 정보 수정 폼 보여주기
    @GetMapping("/member/edit")
    public String showEditForm( Model model, HttpSession session) {

        Member loggedInMember = (Member) session.getAttribute("loggedInMember");

        if (loggedInMember == null) {
            return "redirect:/member/view";

        } else {

            loggedInMember.setMpass("");
            model.addAttribute("member", loggedInMember);
            return "editMember"; // 수정 폼으로 이동
        }
    }

    @PostMapping("/member/edit")
    public String updateMember(@ModelAttribute("member") @Valid Member updatedMember,
                               BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            return "editMember"; // 입력 폼으로 다시 이동
        }
        Member existingMemberOpt = memberService.findMemberById(updatedMember.getMid());
        if (existingMemberOpt == null) {
            model.addAttribute("error", "회원 정보를 찾을 수 없습니다.");
            return "main";
        } else {
            Member existingMember = existingMemberOpt;

            // 기존 정보를 새로 입력된 정보로 업데이트
            existingMember.setMpass(updatedMember.getMpass());
            existingMember.setMnick(updatedMember.getMnick());
            existingMember.setMbirth(updatedMember.getMbirth());
            existingMember.setMphone(updatedMember.getMphone());
            existingMember.setMemail(updatedMember.getMemail());
            existingMember.setMaddr(updatedMember.getMaddr());

            memberService.updateMember(existingMember); // 회원 정보 업데이트
            model.addAttribute("message", "회원 정보가 성공적으로 수정되었습니다.");
            return "redirect:/member/view";
        }
    }
    // 마이페이지
    @GetMapping("/myPage")
    public String showMyPage(HttpSession session, Model model) {
        Member loggedInMember = (Member) session.getAttribute("loggedInMember");
        if (loggedInMember == null) {
            // 로그인되지 않은 상태에서 접근 시 예외 처리 또는 로그인 페이지로 리다이렉트
            return "redirect:/login"; // 예시로 로그인 페이지로 리다이렉트 설정
        }
        model.addAttribute("loggedInMember", loggedInMember);
        return "myPage"; // 마이페이지 JSP 파일명
    }

    // 회원 탈퇴
    @PostMapping("/{mno}")
    public String deleteMember(HttpSession session) {
        Member loggedInMember = (Member) session.getAttribute("loggedInMember");
        if (loggedInMember != null) {
            int mno = loggedInMember.getMno();
            memberService.deleteMemberByMno(mno);
            session.invalidate(); // 세션 무효화
            return "redirect:/deleteSuccess";
        } else {
            return "redirect:/login"; // 로그인 정보가 없을 경우 로그인 페이지로 리디렉션
        }
    }

    @GetMapping("/deleteSuccess")
    public String showDeleteSuccess(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("loggedInMember");
            session.invalidate(); // 세션 무효화
        }
        return "deleteSuccess";
    }

    // ID 찾기
    @GetMapping("/findID")
    public String showFindId(){
        return "findID";
    }

    @PostMapping("/findID")
    public String findId(@RequestParam("mname") String mname, @RequestParam("memail") String memail, @RequestParam("mphone") String mphone, Model model) {
        String mid = memberService.findIdByMnameEmailAndPhone(mname, memail, mphone);

        if (mid != null) {
            model.addAttribute("message", "ID 정보는: " + mid);
        } else {
            model.addAttribute("message", "가입된 정보가 없습니다.");
        }

        return "findIDResult";
    }
}
