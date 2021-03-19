package com.limdongjin.springexamplestudy.demo.service;

import com.limdongjin.springexamplestudy.demo.domain.Member;
import com.limdongjin.springexamplestudy.demo.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /*
     * 회원 가입
     */
    public Long join(Member member) throws IllegalStateException{
        validateDuplicatedMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    /*
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                    .ifPresent(m -> {
                        throw new IllegalStateException("이미 존재하는 회원 입니다.");
                    });
    }
}
