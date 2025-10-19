package controller;

import static java.util.Arrays.stream;

import domain.Delimiter;
import domain.NumberList;
import java.util.List;

public class SplitDelimiterNumber {
    Delimiter delimiter = new Delimiter();

    public int calculate(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }

        inputString = extractNewDelimiter(inputString);
        List<Integer> integerList = getIntegerList(inputString);

        return new NumberList(integerList).addCalculate();
    }

    /*
     * 입력 문자열을 구분자로 나누는 기능
     * input(String)
     * output(List<Integer>)
     */
    private List<Integer> getIntegerList(String inputString) {
        String[] splitString = inputString.split(delimiter.getDelimiter());
        List<Integer> integerList = stream(splitString)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();
        return integerList;
    }

    /*
     * 커스텀 구분자 추출 기능
     */
    public String extractNewDelimiter(String inputString) {
        if (inputString.startsWith("//")) {
            int separateIndex = inputString.indexOf("\\n");
            String customDelimiter = inputString.substring(2, separateIndex);
            if (!customDelimiter.equals("-")) {
                delimiter.addDelimiter(customDelimiter);
            }
            if (customDelimiter.equals("-")) {
                inputString = inputString.replaceAll("--", ",-");
            }
            System.out.println(inputString);
            return inputString.substring(separateIndex + 2);
        }
        return inputString;
    }
}
