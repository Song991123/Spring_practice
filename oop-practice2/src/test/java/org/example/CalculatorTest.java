package org.example;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 요구사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * MVC패턴(Model-View-Controller) 기반으로 구현한다.
* */

public class CalculatorTest {
    @DisplayName("덧셈 연산을 정상적으로 수행한다")
    @ParameterizedTest
    @MethodSource("fomulaAndResult") //메소드를 소스로 가질 것
    void calculateTest(int operand1, String operator, int operand2, int result) {
        int calculateresult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        // assertThat : 어떤 조건이 참인지 거짓인지 구분
        // isEqualTo : 대상의 내용 자체를 비교
        assertThat(calculateresult).isEqualTo(result);
    }
    /**테스트용 스트림 리스트*/
    private static Stream<Arguments> fomulaAndResult()
    {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }
}
