package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/** QueryString에서 여러 개의 값만 추출하는 테스트*/
public class QueryStringsTest {
    @Test
    void createTest() {
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55");

        assertThat(queryStrings).isNotNull();
    }
}
