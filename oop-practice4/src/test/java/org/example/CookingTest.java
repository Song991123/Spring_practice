package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CookingTest {
    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    @Test
    void makeCookTest() {
        // 요리사 객체를 만들고
        Cooking cooking = new Cooking();
        // 내가 원하는 메뉴를 골라서
        MenuItem menuItem = new MenuItem("돈까스", 5000);

        // 요리사에게 만들어달라고 요청한다.
        Cook cook = cooking.makeCook(menuItem);

        // 그 후 만들어진 음식이 제대로 만들어졌는지 확인한다.
        assertThat(cook).isEqualTo(new Cook("돈까스", 5000));
    }
}
