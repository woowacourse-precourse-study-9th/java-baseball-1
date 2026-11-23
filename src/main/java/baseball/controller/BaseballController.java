package baseball.controller;

import baseball.model.number.AnswerNumbers;
import baseball.model.number.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.model.StringParser.parseIntegers;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void run() {

        AnswerNumbers answerNumbers = createAnswerNumbers();
        Numbers numbers = createNumbers();
    }

    private Numbers createNumbers() {
        return new Numbers(readIntegers());
    }

    private List<Integer> readIntegers() {
        return parseIntegers(inputView.readUserNumber());
    }

    private AnswerNumbers createAnswerNumbers() {

        outputView.printStart();
        return new AnswerNumbers();

    }
}
