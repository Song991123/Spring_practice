package org.example;

import java.util.Arrays;
import java.util.IllformedLocaleException;
/**enum으로 계산기를 만드는 방법*/
public enum ArithmeticOperator {
    ADDITION("+"){
        @Override
        public int ArithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-"){
        @Override
        public int ArithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*"){
        @Override
        public int ArithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/"){
        @Override
        public int ArithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    // 추상 메소드

    public abstract int ArithmeticCalculate(final int operand1, final int operand2);

    public static int calculate(int operand1, String operator, int operand2) {
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())
                // enum의 String 값과 들어온 String 값이 같으면
                .filter(v -> v.operator.equals(operator))
                // 그 중 같은 것을 찾고
                .findFirst()
                // 없으면 메세지를 보낸다
                .orElseThrow(() -> new IllformedLocaleException("올바른 사칙연산이 아닙니다."));

        // 찾은 enum값에 해당되는 연산을 수행해준다.
        return arithmeticOperator.ArithmeticCalculate(operand1, operand2);
    }
}
