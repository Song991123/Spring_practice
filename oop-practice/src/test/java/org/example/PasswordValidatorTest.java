package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/*
* 비밀번호는 최소 8자 이상 12자 이하여야 한다.
* 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
* 경계조건에 대해 테스트 코드를 작성해야 한다
*/
public class PasswordValidatorTest {
    //테스트 코드 작성 전 테스트 코드의 의도를 나타내준다.
    @DisplayName("비밀번호는 최소 8자 이상 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatorPasswordTest() {
        //PasswordValidator라는 객체(클래스)에게 "serverwizard"의 validate를 맡김
        //밑의 assertThatCode : 예외를 던지지 않는 경우 처리를 확인
        assertThatCode(() -> PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    // Tip! ) 테스트 코드 작성 시에는 경계 조건에 대한 테스트 코드를 꼭 작성해줄 것

    /* ============= 경계 검사용 ============= */
    //ParameterizedTest : 하나의 테스트 메소드로 여러 개의 파라미터에 대해 테스트 가능
    @ParameterizedTest
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"}) //7자에서 13자(8자 미만, 12자 초과)
    /*  ==================================== */

    void validatorPasswordTest2(String password) {
        // IllegalArgumentException : 부적절한 인수가 넘겨졌을 때 발생
        // isInstanceOf             : 객체 타입 확인
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
