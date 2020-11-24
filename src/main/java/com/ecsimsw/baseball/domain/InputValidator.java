package com.ecsimsw.baseball.domain;

import java.util.HashSet;

public class InputValidator {

    private static final int INPUT_LEN = 3;
    private static final int INPUT_MIN = 1;
    private static final int INPUT_MAX = 9;

    private static final String PLAY_AGAIN = "1";
    private static final String QUIT = "2";

    public static boolean isValidGuess(String userInput){
        if(!isValidLength(userInput)){
            return false;
        }
        else if(!isAllDigit(userInput)){
            return false;
        }
        else if(!isValidRange(userInput)){
            return false;
        }
        else if(!isAllDifferent(userInput)){
            return false;
        }
        return true;
    }

    private static boolean isValidLength(String userInput){
        if(userInput.length() == INPUT_LEN){
            return true;
        }
        return false;
    }

    private static boolean isAllDigit(String userInput){
        try{
            Integer.parseInt(userInput);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    private static boolean isValidRange(String userInput){
        char[] chars = userInput.toCharArray();
        for(char c : chars){
            if( Character.getNumericValue(c) < INPUT_MIN || Character.getNumericValue(c) > INPUT_MAX){
                return false;
            }
        }
        return true;
    }

    private static boolean isAllDifferent(String userInput){
        HashSet<Character> charSet = new HashSet<>();
        char[] chars = userInput.toCharArray();
        for(char c : chars){
            charSet.add(c);
        }
        if(chars.length != charSet.size()){
            return false;
        }
        return true;
    }

    public static boolean isValidAgainAnswer(String userInput){
       if(userInput.equals(PLAY_AGAIN) || userInput.equals(QUIT)){
           return true;
       }
       return false;
    }
}
