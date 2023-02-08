package org.example.calculate;
/**양수 여부를 판단하는 객체*/
// 무조건 양수임을 보장
public class PositiveNumber {
    private final int value;

    /**객체 생성기*/
    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    /**양수 음수 확인 후 음수면 예외처리를 던져버림*/
    private void validate(int value) {
        if(isNegativeNumber(value)){
            throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
        }
    }
    /**양수, 음수 판단기*/
    private boolean isNegativeNumber(int value){
        return value <= 0;
    }

    public int toInt()
    {
        return value;
    }
}
