package baseball.controller;

import baseball.model.Result;
import baseball.model.number.Numbers;
import baseball.model.number.RandomIntegersGenerator;
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

        Numbers answerNumbers = createAnswerNumbers();

        gameStart(answerNumbers);


    }

    private void gameStart(Numbers answerNumbers) {
        boolean retry = true;

        while(retry){
            attemptTo(answerNumbers);
            outputView.printRightAnswer();
            String str = inputView.readRestartRequest();
        }
    }

    private void attemptTo(Numbers answerNumbers) {
        Result result = null;

        while(result.hasThreeStrike()){

            Numbers numbers = createNumbers();
            result = new Result(answerNumbers,numbers);
            outputView.printResult(result);

        }

    }

    private Numbers createNumbers() {
        return new Numbers(readIntegers());
    }

    private List<Integer> readIntegers() {
        return parseIntegers(inputView.readUserNumber());
    }

    private Numbers createAnswerNumbers() {

        outputView.printStart();
        return new Numbers(new RandomIntegersGenerator().RandomIntegersGenerator());

    }
}
