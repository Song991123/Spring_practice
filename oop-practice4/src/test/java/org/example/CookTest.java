package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class CookTest {
    @DisplayName("요리를 생성한다.")
    @Test
    void createTest() {
        // 요리 생성 시 어떠한 Exception도 발생하지 않는다
        assertThatCode(() -> new Cook("만두", 5000))
                .doesNotThrowAnyException();
    }
}
