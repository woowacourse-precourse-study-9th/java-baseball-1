package baseball.model;

import baseball.model.number.Numbers;

import java.util.EnumMap;

import java.util.Map;

public class Result {

    private final Map<Count , Integer> map ;

    public Result(Numbers answerNumbers, Numbers numbers) {


        int strike = answerNumbers.countStrike(numbers);
        int ball = answerNumbers.countBall(numbers) - strike;

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


    public Map<Count, Integer> getMap() {
        return map;
    }

    public Integer get(Count count) {
        return map.get(count);
    }


}
