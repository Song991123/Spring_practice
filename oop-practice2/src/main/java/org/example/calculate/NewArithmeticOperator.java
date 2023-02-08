package org.example.calculate;

/**계산할 데이터를 담을 인터페이스*/
public interface NewArithmeticOperator {
    boolean supports(String operator);
    int calcurate(PositiveNumber operand1, PositiveNumber operand2);
}