package baseball.model.number;

import java.util.ArrayList;
import java.util.List;

public class Numbers {


    private final List<Number> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers =  transferNumbers(numbers);
    }

    private List<Number> transferNumbers(List<Integer> numbers) {
        List<Number> numberList = new ArrayList<>();

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
}
