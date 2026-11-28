package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumbers;
import baseball.domain.GameCommand;
import baseball.domain.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;

    public GameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play() {
        outputView.printStart();
        do {
            playOneGame();
        } while (askRestart());
    }

    private void playOneGame() {
        BaseballGame game = BaseballGame.of(BaseballNumbers.randomNumber());
        GameResult result;

        do {
            BaseballNumbers userNumber = readUserNumber();
            result = judgedUserNumber(game, userNumber);
        } while (isPlaying(result));

        outputView.printEnd();
    }

    private GameResult judgedUserNumber(BaseballGame game, BaseballNumbers userNumber) {
        GameResult result;
        result = game.judge(userNumber);
        outputView.printResult(result);
        return result;
    }

    private BaseballNumbers readUserNumber() {
        outputView.printAskNumber();
        BaseballNumbers userNumber = readUserNumberInput();
        return userNumber;
    }

    private boolean isPlaying(GameResult result) {
        return result.isGameOver() == false;
    }

    private BaseballNumbers readUserNumberInput() {
        String input = inputView.readUserInput();
        return BaseballNumbers.from(input);
    }

    private boolean askRestart() {
        outputView.printAskRestart();
        GameCommand command = GameCommand.from(inputView.readUserInput());

        return command.isRestart();
    }
}