package com.limdongjin.springexamplestudy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    // 스프링부트에 내장된 tomcat 을 띄워준다.
    // spring-boot-starter-web -> spring-boot-starter-tomcat
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
