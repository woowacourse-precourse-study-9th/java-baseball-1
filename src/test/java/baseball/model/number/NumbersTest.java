package baseball.model.number;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class NumbersTest {


    @Test
    void 중복_없는_3자리_양수라면_정상(){

        assertThatCode(() -> new Numbers(List.of(1,4,6)))
                .doesNotThrowAnyException();
    }

    @Test
    void 중복된_숫자가_있다면_예외(){
        assertThatThrownBy( () -> new Numbers(List.of(1,2,1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자릿수가_3자리가_아니라면_예외(){
        assertThatThrownBy( () -> new Numbers(List.of(1,2,1,4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}