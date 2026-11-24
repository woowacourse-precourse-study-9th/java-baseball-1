package baseball.model.number;

import java.util.ArrayList;
import java.util.List;

public class Numbers {


    private static final int NUMBERS_LENGTH = 3;
    private final List<Number> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers =  transferNumbers(numbers);
    }

    private List<Number> transferNumbers(List<Integer> numbers) {
        List<Number> numberList = new ArrayList<>();

        validateNumber(numbers);

        for(int number :numbers ){
            numberList.add(new Number(number));
        }

        return numberList;

    }


    public int countStrike(Numbers others) {
        int count = 0;

        for(int i=0;i<this.numbers.size();i++){

            Number myNumber = this.numbers.get(i);
            Number otherNumber = others.numbers.get(i);
            count += countIfSame(myNumber,otherNumber);

        }
        return  count;

    }



    public int countBall(Numbers others) {

        int count = 0;

        for(int i=0;i<this.numbers.size();i++){

            Number otherNumber = others.numbers.get(i);
            count += countIfBall(otherNumber );

        }
        return  count;

    }

    private int countIfBall( Number otherNumber) {
        int count =0;
        for (Number number : this.numbers) {
            count += countIfSame(number, otherNumber);
        }
        return count;
    }

    private int countIfSame(Number myNumber,Number otherNumber) {

        if(myNumber.isSame(otherNumber)){
            return 1;
        }
        return 0;
    }

    public List<Number> getNumbers() {
        return numbers;
    }


    private void validateNumber(List<Integer> numbers) {
        validListSizeIs3(numbers);
        validDuplicate(numbers);
    }



    private void validListSizeIs3(List<Integer> list) {
        if(list.size() != NUMBERS_LENGTH){
            throw new IllegalArgumentException("3자리를 입력해야 합니다.");
        }
    }


    private void validDuplicate(List<Integer> list) {

        int size = (int) list.stream()
                .distinct()
                .count();

        if(size != list.size()){
            throw new IllegalArgumentException("숫자를 중복하여 입력했습니다.");
        }
    }

}
