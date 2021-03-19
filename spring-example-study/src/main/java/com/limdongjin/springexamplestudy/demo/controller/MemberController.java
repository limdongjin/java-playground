package com.limdongjin.springexamplestudy.demo.controller;

import com.limdongjin.springexamplestudy.demo.domain.Member;
import com.limdongjin.springexamplestudy.demo.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    // @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();

        // 1. attribute 이름 직접 설정
        // model.addAttributes("members", members);

        //2. attribute 이름을 conventional 하게 자동으로 설정해줌.
        // 이 경우에는 memberlist 가 된다.
        model.addAttribute(members);

        return "members/memberList";
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

}