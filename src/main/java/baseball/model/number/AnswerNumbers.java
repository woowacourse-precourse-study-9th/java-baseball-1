package baseball.model.number;

import java.util.List;

public class AnswerNumbers {

    private final Numbers numbers;

    public AnswerNumbers() {
        List<Integer> randomNumbers = new RandomIntegersGenerator().RandomIntegersGenerator();
        this.numbers = new Numbers(randomNumbers);
    }
}
