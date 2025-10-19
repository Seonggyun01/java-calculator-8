package domain;

import java.util.List;

public class NumberLIst {

    private List<Integer> numbers;

    public NumberLIst(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /*
     * 나눠진 숫자 더하는 기능
     * 음수일 경우 예외 발생
     */
    public int addCalculate() {
        int result = 0;
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("음수가 입력되었습니다.");
            }
            result += number;
        }
        return result;
    }
}
