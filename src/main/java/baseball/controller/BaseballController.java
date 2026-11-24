package baseball.controller;

import baseball.model.JudgeTryAgain;
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


        JudgeTryAgain retry = new JudgeTryAgain();

        while (retry.oneMore()) {
            Numbers answerNumbers = createAnswerNumbers();
            playGame(answerNumbers);
            outputView.printRightAnswer();
            retry.checkTry(parseIntegers(inputView.readRestartRequest()));
        }


    }


    private void playGame(Numbers answerNumbers) {

        Result result;
        do {

            result = playRound(answerNumbers);
            outputView.printRoundResult(result);

        } while (!result.hasThreeStrike());

    }

    private Result playRound(Numbers answerNumbers) {

        Numbers numbers = createNumbers();
        return new Result(answerNumbers, numbers);

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
