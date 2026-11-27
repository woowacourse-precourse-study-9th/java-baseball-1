package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
유효한 야구숫자를 유지하라
다른 야구 숫자와 비교하라
 */

public class BaseballNumber {
    private final List<Integer> numbers;

    // 초기화 및 검증
    public BaseballNumber(List<Integer> numbers){
        validate(numbers);
        // this.numbers = numbers; 참조값을 복사하기 때문에 외부에서 numbers를 변경하면 이 클래스 내부 numbers도 변경될 수 있다. 그럼 validate를 해도 numbers가 바뀔 수 있는 문제
        this.numbers = List.copyOf(numbers);
    }

    // 검증
    private void validate(List<Integer> numbers){
        // 세자리어야 한다.
        if (numbers.size() != 3){
            throw new IllegalArgumentException();
        }

        // 중복이 없어야한다
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numbers.size() != numSet.size()){
            throw new IllegalArgumentException();
        }

        // 1~9의 숫자어야한다.
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) < 1 || numbers.get(i) > 9){
                throw new IllegalArgumentException();
            }
        }
    }

    // 다른 야구 숫자와 비교하라 (스트라이크, 볼 판정을 위한 비교)
    public Result compare(BaseballNumber other){
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.contains(other.numbers.get(i))){
                if (numbers.get(i).equals(other.numbers.get(i))){
                    strike++;
                } else{
                    ball++;
                }
            }
        }
        return new Result(strike, ball);
    }
}