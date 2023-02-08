package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/** QueryString에서 하나의 값만 추출하는 테스트*/
public class QueryStringTest {
    @Test
    void createTest() {
        // 여러 개의 값을 넣으려면 List<QueryString>을 만들면 됨 -> 일급 컬렉션 제작
        QueryString queryString = new QueryString("operand1", "11");

        assertThat(queryString).isNotNull();
    }
}
