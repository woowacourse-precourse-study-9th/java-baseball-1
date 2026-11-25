package baseball.model.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomIntegersGenerator {


    public List<Integer> RandomIntegersGenerator() {

        List<Integer> computer = new ArrayList<>();

        while (isSizeLessThan3(computer)) {
            tryAddInteger(computer);
        }

        return computer;
    }

    private void tryAddInteger(List<Integer> computer) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }

    }

    private boolean isSizeLessThan3(List<Integer> computer) {
        return computer.size() < 3;
    }
}
