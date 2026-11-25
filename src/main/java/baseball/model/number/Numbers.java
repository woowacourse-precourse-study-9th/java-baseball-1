package baseball.model.number;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Numbers {


    private static final int NUMBERS_LENGTH = 3;
    private final List<Number> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = transferNumbers(numbers);
    }

    private List<Number> transferNumbers(List<Integer> numbers) {
        List<Number> numberList = new ArrayList<>();

        validateNumber(numbers);

        for (int number : numbers) {
            numberList.add(new Number(number));
        }

        return numberList;

    }


    public int countStrike(Numbers others) {
        return (int) IntStream.range(0, NUMBERS_LENGTH)
                .filter(index -> isSameNumberAndIndex(others, index))
                .count();
    }

    private boolean isSameNumberAndIndex(Numbers others, int index) {

        return getNumber(index).isSame(others.getNumber(index));

    }

    private Number getNumber(int index) {
        return numbers.get(index);
    }


    public int countBall(Numbers others) {

        return (int) IntStream.range(0,NUMBERS_LENGTH)
                .filter(index -> isSameNumberNotSameIndex(others,index))
                .count();

    }

    private boolean isSameNumberNotSameIndex(Numbers others, int index) {

        return numbers.contains(others.getNumber(index)) && !isSameNumberAndIndex(others,index);
    }





    private void validateNumber(List<Integer> numbers) {
        validListSizeIs3(numbers);
        validDuplicate(numbers);
    }


    private void validListSizeIs3(List<Integer> list) {
        if (list.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException("3자리를 입력해야 합니다.");
        }
    }


    private void validDuplicate(List<Integer> list) {

        int size = (int) list.stream()
                .distinct()
                .count();

        if (size != list.size()) {
            throw new IllegalArgumentException("숫자를 중복하여 입력했습니다.");
        }
    }

}
