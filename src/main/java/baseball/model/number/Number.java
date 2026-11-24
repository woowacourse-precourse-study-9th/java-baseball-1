package baseball.model.number;

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

    public int getNumber() {
        return number;
    }
}
