package com.song.webservice.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)  // 테스트를 진행할 때, JUnit에 내장된 실행자 외에 다른 실행자(= SpringExtension)를 실행한다. = Spring Boot Test와 JUnit의 연결자 역할
@WebMvcTest(controllers = HelloController.class)    // Web(Spring MVC)에 집중할 수 있는 Annotation
public class HelloControllerTest {

    @Autowired  // 생성자나 세터 등을 사용하여 의존성 주입을 하려고 할 때, Spring이 관리하는 해당 빈을 찾아서 주입
    private MockMvc mvc;    // 웹 API 테스트 = Spring MVC 테스트의 시작점 = API 테스트

    @Test
    public void helloReturn() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDtoReturn() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
