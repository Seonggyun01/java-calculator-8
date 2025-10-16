package domain;

import java.util.regex.Pattern;

public class Delimiter {
    //기본 구분자
    private String delimiter = "[,:]";

    public String getDelimiter() {
        return delimiter;
    }

    //커스텀 구분자 추가
    public void addDelimiter(String newDelimiter) {
        if (!newDelimiter.isEmpty()) {
            delimiter = delimiter + "|" + Pattern.quote(newDelimiter);
        }
    }
}
