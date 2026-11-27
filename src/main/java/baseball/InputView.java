package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<Integer> readBaseballNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            numbers.add(input.charAt(i) - '0');
        }
        return numbers;
    }

    public boolean readRestart(){
        int restart = Integer.parseInt(Console.readLine());
        if (restart == 1) {
            return true;
        } else if (restart == 2){
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
