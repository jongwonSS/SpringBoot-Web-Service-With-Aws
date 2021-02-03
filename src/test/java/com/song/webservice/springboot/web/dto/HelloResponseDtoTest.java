package com.song.webservice.springboot.web.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombokUnitTest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        ///then
        assertThat(dto.getName()).isEqualTo(name);      // assertji 테스트 검증 라이브러리의 검증 메소드 + 메소드 체이닝 지원
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
