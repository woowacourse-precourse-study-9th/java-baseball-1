package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    public static List<Integer> parseIntegers(String input){

        List<Integer> list = transferInputToIntegers(input);

        validDuplicate(list);


        return list;
    }

    private static List<Integer> transferInputToIntegers(String input) {
        List<Integer> list = new ArrayList<>();
        for(char c : input.toCharArray()){

            list.add(parseInteger(c));

        }
        return list;
    }

    private static void validDuplicate(List<Integer> list) {

        int size = (int) list.stream()
                .distinct()
                .count();

        if(size != list.size()){
            throw new IllegalArgumentException("숫자를 중복하여 입력했습니다.");
        }
    }

    private static int parseInteger(char c) {

        if(!Character.isDigit(c)){
            throw new IllegalArgumentException("입력값은 숫자여야 합니다");
        }

        int number  = c - '0';

        if(!isRange1to9(number)){
            throw new IllegalArgumentException("입력 숫자는 1~9 사이여야 합니다.");
        }

        return number;
    }

    private static boolean isRange1to9(int number) {
        return 0 < number && number < 10;
    }


}
