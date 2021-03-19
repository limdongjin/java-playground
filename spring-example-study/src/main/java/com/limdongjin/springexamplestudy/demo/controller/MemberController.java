package com.limdongjin.springexamplestudy.demo.controller;

import com.limdongjin.springexamplestudy.demo.domain.Member;
import com.limdongjin.springexamplestudy.demo.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    @ResponseBody
    public String getMembers(){
        return memberService.findMembers().toString();
    }
}