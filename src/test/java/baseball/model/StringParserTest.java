package baseball.model;

import org.junit.jupiter.api.Test;


import static baseball.model.StringParser.parseIntegers;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringParserTest {


    @Test
    void 숫자라면_정상(){
        assertThatCode( () -> parseIntegers("123")).doesNotThrowAnyException();
    }

    @Test
    void 숫자가_아니라면_예외(){
        assertThatThrownBy( () -> parseIntegers("a23")).isInstanceOf(IllegalArgumentException.class);
    }

}