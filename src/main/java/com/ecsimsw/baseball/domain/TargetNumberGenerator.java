package com.ecsimsw.baseball.domain;

import java.util.ArrayList;
import java.util.Random;

public class TargetNumberGenerator {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int TARGET_NUM_LEN = 3;

    private final ArrayList<Integer> targetNumberList;

    public TargetNumberGenerator(){
        targetNumberList = setTargetNumberList();
    }

    public ArrayList<Integer> getTargetNumberList(){
        return targetNumberList;
    }

    private ArrayList<Integer> setTargetNumberList(){
        ArrayList<Integer> targetNumberList = new ArrayList<>();

        while(targetNumberList.size() < TARGET_NUM_LEN){
            int randomDigit = getRandomDigit();
            if(targetNumberList.contains(randomDigit)) {
                continue;
            }
            targetNumberList.add(randomDigit);
        }
        return targetNumberList;
    }

    private int getRandomDigit(){
        Random random = new Random();
        return random.nextInt(MAX_NUM) + MIN_NUM;
    }
}
