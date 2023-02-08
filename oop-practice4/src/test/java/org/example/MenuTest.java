package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class MenuTest {
    @DisplayName("메뉴판에서 메뉴 이름에 해당하는 메뉴를 반환한다.")
    @Test
    void chooseTest() {
        // 메뉴 목록을 생성
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));

        // 메뉴 선택
        MenuItem menuItem = menu.choose("돈까스");

        // 돈까스가 정말 맞는지
        assertThat(menuItem).isEqualTo(new MenuItem("돈까스", 5000));
    }

    @DisplayName("메뉴판에 없는 메뉴 선택 시 에러를 반환한다.")
    @Test
    void chooseTest2() {
        // 메뉴 목록을 생성
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));
        assertThatCode(() -> menu.choose("통닭"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름입니다.");
    }
}
