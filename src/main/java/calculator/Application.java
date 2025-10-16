package calculator;

import static java.util.Arrays.stream;

import camp.nextstep.edu.missionutils.Console;
import domain.Delimiter;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Delimiter delimiter = new Delimiter();

        // 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        int result = 0;

        //입력 문자열이 null이나 공백인 경우
        if (inputString == null || inputString.isEmpty()) {
            System.out.println("결과 : " + result);
            return;
        }

        //입력 문자열을 구분자로 나누고 더하는 기능
        String[] splitString = inputString.split(delimiter.getDelimiter());
        List<Integer> integerList = stream(splitString).map(Integer::parseInt).toList();
        for (Integer num : integerList) {
            result += num;
        }
        System.out.println("결과 : " + result);
        Console.close();
    }
}
