package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() {
        // given ==================
        // 유저가 주어졌고
        User user = new User();

        // when ==================
        // 이 메소드를 호출 시
//        user.initPassword(new CorrectFixedPasswordGenerator());  //테스트 클래스를 만든 경우
        user.initPassword(() -> "abcdefg3678");                    //람다식을 이용한 경우

        // then ==================
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화되지 않는다.")
    @Test
    void passwordTest2() {
        // given ==================
        // 유저가 주어졌고
        User user = new User();

        // when ==================
        // 이 메소드를 호출 시
//        user.initPassword(new WrongFixedPasswordGenerator());  //테스트 클래스를 만든 경우
        user.initPassword(() -> "ab");                           //람다식을 이용한 경우

        // then ==================
        assertThat(user.getPassword()).isNull();
    }
}