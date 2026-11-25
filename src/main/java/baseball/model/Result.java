package baseball.model;

import baseball.model.number.Numbers;

import java.util.EnumMap;

import java.util.Map;
import java.util.Set;

public class Result {

    public static final int GOAL_STRIKE = 3;
    private final Map<Count , Integer> map ;

    public Result(Numbers answerNumbers, Numbers numbers) {


        int strike = answerNumbers.countStrike(numbers);
        int ball = answerNumbers.countBall(numbers);

        this.map = creatMap(strike,ball);

    }

    private Map<Count, Integer> creatMap(int strike, int ball) {

        Map<Count , Integer> map = new EnumMap<>(Count.class);

        if(isNothing(strike, ball)){
            map.put(Count.NONE,null);
            return map;
        }

        if(isPositive(strike)){
            map.put(Count.STRIKE, strike );
            
        }
        if(isPositive(ball)){
            map.put(Count.BALL, ball);
        }

        return map;
    }

    private boolean isPositive(int strike) {
        return strike != 0;
    }

    public boolean isNothing() {
        return map.containsKey(Count.NONE);
    }

    private boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }


    public Integer get(Count count) {
        return map.get(count);
    }


    public boolean hasThreeStrike() {
        return map.getOrDefault(Count.STRIKE, 0) == GOAL_STRIKE;
    }


    public Set<Count> getKeySet() {
        return map.keySet();
    }
}
