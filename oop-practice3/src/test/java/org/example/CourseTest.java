package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

/** 이수한 과목의 테스트 코드 */
public class CourseTest {
    @DisplayName("과목(코스)를 생성한다.")
    @Test
    void createTest() {
        assertThatCode(() -> new Course("OOP",3,"A+"))
                //doesNotThrowAnyException : 위의 코드가 정상적으로 실행됐다면, 어떠한 Exception도 발생하지 않는다.
                .doesNotThrowAnyException();
    }
}
