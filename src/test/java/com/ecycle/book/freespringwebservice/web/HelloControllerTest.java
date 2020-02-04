package com.ecycle.book.freespringwebservice.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //springRUnner 라는 스프링 실핼자를 사용하며 Junit과 스프링의 연결자 역할을 함
@WebMvcTest // SpringMvc에 집중할 수 있는 테스트 어노테이션, Controller, COntrollerAdvice 사용 가능
public class HelloControllerTest {

    @Autowired  // 빈 주입
    private MockMvc mvc;    //웹 API 테스트시 사용, Get, Post 등에 대한 API테스트 가

    @Test
    public void hello가_리턴됨() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello)) ;
    }

    @Test
    public void HelloDto가_리턴됨() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
        .param("name", name)
        .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) //$.으로 json field명 설정
                .andExpect(jsonPath("$.amount",is(amount)));
    }

}