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
            String result = "";
            if (answer.ball() > 0){
                result += answer.ball() + "볼 ";
            }

            if (answer.strike() > 0){
                result += answer.strike() + "스트라이크";
            }

            if (result.isEmpty()){
                result += "낫싱";
            }
            System.out.println(result.trim());
        }
    }
