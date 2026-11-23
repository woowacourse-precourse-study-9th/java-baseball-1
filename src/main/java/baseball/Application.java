package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임 무한 반복
        while (true){

            // 3자리 난수 만들기. list에 넣으며 없으면 넣고, while로 길이가 3이 될 때까지 뽑는다
            List<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 3){
                int newNumber = pickNumberInRange(1,9);
                if (!numbers.contains(newNumber)){
                    numbers.add(newNumber);
                }
            }

            // 맞출 때까지 반복
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                // 입력값 검증: 3자리, 각각 겹치지 않고, 1~9
                // 숫자 세자리
                if (input.length() != 3){
                    throw new IllegalArgumentException();
                // 겹치면 안됨
                } else if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)){
                    throw new IllegalArgumentException();
                // 1~9
                } else {
                    for (int i = 0; i < input.length(); i++){
                        if (input.charAt(i) - '0' < 1 || input.charAt(i) - '0' > 9) {
                            throw new IllegalArgumentException();
                        }
                    }
                }

                // 스트라이크, 볼, none 판정
                int none = 0;
                int ball = 0;
                int strike = 0;
                for (int i = 0; i < input.length(); i++) {
                    // contains 하지 않으면 낫싱
                    int num = input.charAt(i) - '0';
                    if (!numbers.contains(num)) {
                        none++;
                    } else {
                        // 위치가 같다면 스트라이크, 아니면 볼
                        if (numbers.indexOf(num) == i) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }

                // 결과
                if (none == 3) {
                    System.out.println("낫싱");
                } else if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else if (strike == 2 && none == 1) {
                    System.out.println("2스트라이크");
                } else if (strike == 1 && none == 2) {
                    System.out.println("1스트라이크");
                } else if (ball == 3) {
                    System.out.println("3볼");
                } else if (ball == 2 && none == 1) {
                    System.out.println("2볼");
                } else if (ball == 1 && none == 2) {
                    System.out.println("1볼");
                } else if (strike == 2 && ball == 1) {
                    System.out.println("1볼 2스트라이크");
                } else if (strike == 1 && ball == 2) {
                    System.out.println("2볼 1스트라이크");
                } else if (strike == 1 && ball == 1){
                    System.out.println("1볼 1스트라이크");
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
