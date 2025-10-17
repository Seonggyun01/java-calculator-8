package domain;

import static java.util.Arrays.stream;

import java.util.List;

public class SplitStringAddCalculate {
    Delimiter delimiter = new Delimiter();

    public int calculate(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }
        int result = 0;

        //커스텀 구분자 추가 기능
        if (inputString.startsWith("//")) {
            int separateIndex = inputString.indexOf("\\n");
            String customDelimiter = inputString.substring(2, separateIndex);
            inputString = inputString.substring(separateIndex + 2);
            delimiter.addDelimiter(customDelimiter);
        }

        //입력 문자열을 구분자로 나누고 더하는 기능
        String[] splitString = inputString.split(delimiter.getDelimiter());
        List<Integer> integerList = stream(splitString)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();
        for (Integer num : integerList) {
            //음수인 경우 예외 발생
            if (num < 0) {
                throw new IllegalArgumentException("음수가 입력되었습니다.");
            }
            result += num;
        }
        return result;
    }
}
