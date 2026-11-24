package baseball.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JudgeTryAgainTest {

    JudgeTryAgain judgeTryAgain;

    @BeforeEach
    void setUp() {
        judgeTryAgain = new JudgeTryAgain();
    }

    @ParameterizedTest
    @MethodSource("일과이")
    void 입력값이_1_또는_2_라면_정상(List<Integer> numbers) {

        assertThatCode(() -> judgeTryAgain.checkTry(numbers))
                .doesNotThrowAnyException();

    }

    static Stream<List<Integer>> 일과이() {

        return Stream.of(
                List.of(1),
                List.of(2)
        );
    }

    @ParameterizedTest
    @MethodSource("일과이빼고")
    void 입력값이_1_또는_2_가_아니라면_예외(List<Integer> numbers) {
        assertThatThrownBy(() -> judgeTryAgain.checkTry(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> 일과이빼고() {

        return Stream.of(
                List.of(4),
                List.of(5),
                List.of(199)
        );
    }

}