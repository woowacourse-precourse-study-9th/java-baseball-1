package baseball;

public class OutputView {

    public void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void printRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public void printResult(Result answer){
        if (answer.strike() == 3) {
            System.out.println("3스트라이크");
        } else if (answer.strike() == 2) {
            if (answer.ball() == 1) {
                System.out.println("1볼 2스트라이크");
            } else {
                System.out.println("2스트라이크");
            }
        } else if (answer.strike() == 1) {
            if (answer.ball() == 2) {
                System.out.println("2볼 1스트라이크");
            } else if (answer.ball() == 1) {
                System.out.println("1볼 1스트라이크");
            } else {
                System.out.println("1스트라이크");
            }
        } else if (answer.ball() == 3){
            System.out.println("3볼");
        } else if (answer.ball() == 2){
            System.out.println("2볼");
        } else if (answer.ball() == 1){
            System.out.println("1볼");
        } else {
            System.out.println("낫싱");
        }
    }
}
