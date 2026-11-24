package baseball.view;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public String readUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
