package baseball.model;

import java.util.List;

public class JudgeTryAgain {

    public static final int RETRY_NUMBER = 1;
    public static final int END_NUMBER = 2;

    private boolean tryAgain;

    public JudgeTryAgain() {
        this.tryAgain = true;
    }

    public boolean oneMore() {
        return tryAgain;
    }

    public void checkTry(List<Integer> list) {

        validateCheckNumber(list);
        int num = list.get(0);
        if( num == RETRY_NUMBER){
            this.tryAgain = true;
            return;
        }

        if( num == END_NUMBER){

            this.tryAgain = false;

        }


    }

    private void validateCheckNumber(List<Integer> list) {

        if(list.size() != 1){
            throw new IllegalArgumentException("1 또는 2를 입력 해야 합니다.");
        }

        int i =list.get(0);

        if( i != RETRY_NUMBER && i != END_NUMBER){
            throw new IllegalArgumentException("숫자를 잘못 입력하셨습니다. 재시작 숫자는 1, 종료는 2 입니다.");
        }
    }
}
