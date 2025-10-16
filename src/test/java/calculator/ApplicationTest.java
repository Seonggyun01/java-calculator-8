package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_문자열_사용() {
        assertSimpleTest(() -> {
            run("//--\\n1--2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자가_비어있는_테스트() {
        assertSimpleTest(() -> {
            run("//\\n1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//--\\n1---2"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 빈문자열_입력_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자_없이_숫자_하나_입력() {
        assertSimpleTest(() -> {
            run("3");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 기본_구분자_혼합_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
