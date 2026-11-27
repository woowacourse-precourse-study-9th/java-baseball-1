package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {
    public List<Integer> generateNumbers (){
        // 난수 생성 함수
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3){
            int newNumber = pickNumberInRange(1,9);
            if (!numbers.contains(newNumber)){
                numbers.add(newNumber);
            }
        }
        return numbers;
    }
}

