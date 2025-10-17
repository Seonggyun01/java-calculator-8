package calculator;

import camp.nextstep.edu.missionutils.Console;
import domain.Delimiter;
import domain.SplitStringAddCalculate;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Delimiter delimiter = new Delimiter();
        SplitStringAddCalculate splitStringAddCalculate = new SplitStringAddCalculate();

        // 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        Console.close();

        int result = splitStringAddCalculate.calculate(inputString);

        System.out.println("결과 : " + result);
    }
}
