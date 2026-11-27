package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
/*
Application은 게임의 진행을 담당한다.
1. 게임을 시작한다.
2. 컴퓨터 숫자를 생성한다.
3. 사용자의 숫자를 입력받는다.
4. 두 숫자를 비교한다.
5. 판정결과를 출력한다.
6. 정답이면 재시작 여부를 결정한다.
 */
public class Application {

    // 난수 생성 함수
    public static List<Integer> generateNumbers(){
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3){
            int newNumber = pickNumberInRange(1,9);
            if (!numbers.contains(newNumber)){
                numbers.add(newNumber);
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 1. 게임을 시작한다.
        outputView.printGameStart();

        while (true){
            BaseballNumber computer = new BaseballNumber(generateNumbers()); // 2. 컴퓨터 숫자를 생성한다.

            while (true) {
                // 3. 사용자의 숫자를 입력받는다.
                BaseballNumber player = new BaseballNumber(inputView.readBaseballNumbers());

                // 4. 두 숫자를 비교한다.
                Result answer = computer.compare(player);

                // 5. 판정결과를 출력한다.
                outputView.printResult(answer);

                if (answer.isCorrect()){
                    outputView.printGameEnd();
                    break;
                }
            }

            // 6. 정답이면 재시작 여부를 결정한다.
            outputView.printRestart();
            if (!inputView.readRestart()){
                break;
            };
        }
    }
}
