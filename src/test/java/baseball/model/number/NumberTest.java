package baseball.model.number;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 숫자가_1부터_9까지면_예외가_없다(int number) {
        assertThatCode( () -> new Number(number))
                .doesNotThrowAnyException();



    }
}
