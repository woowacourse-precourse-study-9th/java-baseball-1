package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
/*
main의 4가지 기능을 메소드로 분리한다.
1. 난수생성 기능
2. 입력값 검증 기능
3. 판정 기능
4. 결과출력 기능
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

    // 입력값 검증 함수
    public static void validateInput(String input){
        // 숫자 세자리인가?
        if (input.length() != 3){
            throw new IllegalArgumentException();
            // 겹치지는 않는가?
        } else if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)){
            throw new IllegalArgumentException();
            // 1~9인가?
        } else {
            for (int i = 0; i < input.length(); i++){
                if (input.charAt(i) - '0' < 1 || input.charAt(i) - '0' > 9) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    // 스트라이크, 볼 판정 함수
    public static Result judge(String input, List<Integer> numbers) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            // 위치가 같다면 스트라이크, 아니면 볼
            if (numbers.indexOf(num) == i) {
                strike++;
            } else {
                if (numbers.contains(num)) {
                    ball++;
                }
            }
        }
        return new Result(strike, ball);
    }

    // judge 메서드의 결과의 가독성을 위한 record 데이터타입
    record Result(int strike, int ball){}

    // 결과출력 함수
    public static void printResult(Result answer){
        if (answer.strike == 3) {
            System.out.println("3스트라이크");
        } else if (answer.strike == 2) {
            if (answer.ball == 1) {
                System.out.println("1볼 2스트라이크");
            } else {
                System.out.println("2스트라이크");
            }
        } else if (answer.strike == 1) {
            if (answer.ball == 2) {
                System.out.println("2볼 1스트라이크");
            } else if (answer.ball == 1) {
                System.out.println("1볼 1스트라이크");
            } else {
                System.out.println("1스트라이크");
            }
        } else if (answer.ball == 3){
            System.out.println("3볼");
        } else if (answer.ball == 2){
            System.out.println("2볼");
        } else if (answer.ball == 1){
            System.out.println("1볼");
        } else {
            System.out.println("낫싱");
        }
    }


    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            List<Integer> numbers = generateNumbers(); // 3자리 난수 생성

            while (true) { // 맞출 때까지 반복
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                validateInput(input); // 입력값 검증
                Result answer = judge(input, numbers); // 스트라이크, 볼, none 판정. 원래 반환을 List<Integer>로 하려고 했는데, result.get(0)를 알아보기 어려울 것 같아서 출력 DTO를 만듬
                printResult(answer); // 결과 출력. 원래 맞추고 종료하는 것도 printResult에 넣으려다, printResult는 print 하는 용도, 게임 종료는 main 역할
                if (answer.strike == 3){ // 게임 종료
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            // 한번 더 할지 종료할지 판단
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restart = Integer.parseInt(Console.readLine());

            if (restart == 2){
                return;
            } else if (restart != 1){
                throw new IllegalArgumentException();
            }
        }
    }
}
