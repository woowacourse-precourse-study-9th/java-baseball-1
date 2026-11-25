package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.number.Numbers;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void 자리와_숫자가_같으면_스트라이크_숫자만_같으면_볼() {
        Numbers answerNumbers = new Numbers(List.of(1, 3, 5));
        Numbers numbers = new Numbers(List.of(1, 5, 9));

        Result result = new Result(answerNumbers, numbers);

        assertThat(result.get(Count.STRIKE)).isEqualTo(1);
        assertThat(result.get(Count.BALL)).isEqualTo(1);
    }

    @Test
    void 숫자만_같다면_볼() {


        Numbers answerNumbers = new Numbers(List.of(1, 2,3));
        Numbers numbers = new Numbers(List.of(2, 3, 1));

        Result result = new Result(answerNumbers, numbers);

        assertThat(result.get(Count.BALL)).isEqualTo(3);
    }
}
