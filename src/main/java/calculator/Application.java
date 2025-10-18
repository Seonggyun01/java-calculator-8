package calculator;

import camp.nextstep.edu.missionutils.Console;
import controller.SplitDelimiterNumber;

public class Application {
    public static void main(String[] args) {
        SplitDelimiterNumber splitStringAddCalculate = new SplitDelimiterNumber();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        Console.close();

        int result = splitStringAddCalculate.calculate(inputString);

        System.out.println("결과 : " + result);
    }
}
