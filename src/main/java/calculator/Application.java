package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        int result = 0;

        //입력 문자열이 null이나 공백인 경우
        if (inputString == null || inputString.isEmpty()) {
            System.out.println("결과 : " + result);
            return;
        }

        System.out.println("결과 : " + result);
        Console.close();
    }
}
