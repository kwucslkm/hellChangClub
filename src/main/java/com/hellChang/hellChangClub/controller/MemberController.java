package com.hellChang.hellChangClub.controller;

import com.hellChang.hellChangClub.dto.BandMemberDTO;
import com.hellChang.hellChangClub.service.BandMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final BandMemberService bandMemberService;
    //회원가입 페이지 출력 요청
    @GetMapping("/main")
    public String goMain(){
        return "home";
    }
    @GetMapping("/memberPages/saveForm")
    public String save(){
        return "healthMemberPages/saveForm";
    }
    @PostMapping("/healthMemberPages/saveForm")
    public String saveForm(@ModelAttribute BandMemberDTO bandMemberDTO){
        System.out.println("MemberController.saveForm");
        System.out.println("bandMemberDTO = " + bandMemberDTO);
        bandMemberService.save(bandMemberDTO);
        return "healthMemberPages/bandMemberLogin";
    }
    @GetMapping("/MemberPages/memberLogin")
    public String loginForm(){
        return "healthMemberPages/bandMemberLogin";
    }
    @PostMapping("/healthMemberPages/bandMemberLogin")
    public String login(@ModelAttribute BandMemberDTO bandMemberDTO, HttpSession httpSession){
        BandMemberDTO loginResult = bandMemberService.login(bandMemberDTO);
        if (loginResult != null){
            httpSession.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "redirect:/healthMemberPages/memberList";
        }else {
            return "healthMemberPages/bandMemberLogin";
        }
    }
    @GetMapping("/healthMemberPages/memberList")
    public String findAll(Model model){
        List<BandMemberDTO> bandMemberDTOList = bandMemberService.findAll();
        model.addAttribute("memberList", bandMemberDTOList);
        return "healthMemberPages/memberList";
    }
@GetMapping("/member/{id}")
    public String findById(@PathVariable Long id, Model model){
    System.out.println("넘어오나 findbyid");
        BandMemberDTO memberDTO = bandMemberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "healthMemberPages/memberDetail";
    }
@GetMapping("/member/fromNav/{memberEmail}")
    public String findByEmail(@PathVariable String memberEmail, Model model){
        System.out.println("연결되나 memberEmail =====> " + memberEmail);
        BandMemberDTO memberDTO =  bandMemberService.findByMemberEmail(memberEmail);
        model.addAttribute("member", memberDTO);
        return "healthMemberPages/memberDetail";
    }
@GetMapping("/healthMemberPages/bandMemberUpdate/{memberEmail}")
    public String memberUpdateForm(@PathVariable String memberEmail, Model model){
       BandMemberDTO memberDTO =  bandMemberService.findByMemberEmail(memberEmail);
//       System.out.println("memberDTO = " + memberDTO);
       model.addAttribute("member", memberDTO);
       return "healthMemberPages/memberUpdateForm";
    }

@GetMapping("healthMemberPages/bandMemberUpdate")
    public String memberUpdateFormM(HttpSession httpSession, Model model) {
        System.out.println("넘어는 오나=====");
        String memberEmail = (String) httpSession.getAttribute("loginEmail");
        BandMemberDTO memberDTO = bandMemberService.findByMemberEmail(memberEmail);
//    System.out.println("memberDTO = " + memberDTO);
        model.addAttribute("member", memberDTO);
        return "healthMemberPages/memberUpdateForm";
    }
@PostMapping("/healthMemberPages/bandMemberUpdate")
    public String memberUpdate(@ModelAttribute BandMemberDTO bandMemberDTO){
        bandMemberService.update(bandMemberDTO);
        return "redirect:/member/"+bandMemberDTO.getId();
    }
@GetMapping("/member/delete/{id}")
    public String memberDelete(@PathVariable Long id){
        bandMemberService.deleteById(id);
        return "redirect:/healthMemberPages/memberList";
}
@GetMapping("/healthMeberPages/mypage")
    public String logout(HttpSession httpSession, Model model){
        httpSession.invalidate();
        model.addAttribute("logoutValue","1");
        return "home";

}
}
