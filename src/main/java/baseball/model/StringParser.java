package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    public static final int NUMBERS_LENGTH = 3;

    public static List<Integer> parseIntegers(String input){

        List<Integer> list = transferInputToIntegers(input);


        return list;
    }


    private static List<Integer> transferInputToIntegers(String input) {
        List<Integer> list = new ArrayList<>();
        for(char c : input.toCharArray()){

            list.add(parseInteger(c));

        }
        return list;
    }



    private static int parseInteger(char c) {

        if(!Character.isDigit(c)){
            throw new IllegalArgumentException("입력값은 숫자여야 합니다");
        }

        int number  = c - '0';

        return number;
    }




}
