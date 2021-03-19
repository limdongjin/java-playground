package com.limdongjin.springexamplestudy.demo;

import com.limdongjin.springexamplestudy.demo.repository.JdbcMemberRepository;
import com.limdongjin.springexamplestudy.demo.repository.MemberRepository;
import com.limdongjin.springexamplestudy.demo.repository.MemoryMemberRepository;
import com.limdongjin.springexamplestudy.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
