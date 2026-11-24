package baseball.model.number;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(int number) {

        validNumber(number);

        this.number = number;

    }

    private void validNumber(int number) {
        if(!isRange1to9(number)){
            throw new IllegalArgumentException("입력 숫자는 1~9 사이여야 합니다.");
        }
    }



    public boolean isSame(Number other) {
        return this.number == other.number;
    }


    private static boolean isRange1to9(int number) {
        return 0 < number && number < 10;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
