package org.example.calculator.domain;
import org.example.calculator.tobe.*;

import java.util.List;

public class Calculator {
    //각각의 구현체들을 상위 인터페이스인 arithmeticOperators를 통해 받는다.
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        /*이전버젼*/
        // enum으로 계산기 구현
//        return ArithmeticOperator.calculate(operand1, operator, operand2);

        return arithmeticOperators.stream()
                //이 오퍼레이터에 해당하는 실제 구현체를 필터링 해서
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                // mapping : 스트림내 요소들에 대해 함수가 적용된 결과의 새로운 요소로 매핑해준다.
                // calcurate 메소드를 실행 시 인자값을 전달하고
                .map(arithmeticOperators -> arithmeticOperators.calcurate(operand1, operand2))
                // 값이 있으면 찾고
                .findFirst()
                // 없으면 메세지를 출력
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
