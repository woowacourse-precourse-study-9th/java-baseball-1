package baseball.view;

import baseball.model.Count;
import baseball.model.Result;
import baseball.model.number.Number;
import baseball.model.number.Numbers;

public class OutputView {

    public void printStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(Result result) {

        if(result.isNothing()){
            System.out.print(Count.NONE.getKor());
            System.out.println();
            return ;
        }

        for(Count count : result.getMap().keySet()){

            System.out.print(result.get(count)+count.getKor()+" ");

        }

        System.out.println();

    }

}
