package com.ecsimsw.baseball;

import com.ecsimsw.baseball.domain.TargetNumberGenerator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BaseballGameApplication {
    public static void main(String[] args){

        TargetNumberGenerator targetNumberGenerator = new TargetNumberGenerator();
        ArrayList<Integer> l = targetNumberGenerator.getTargetNumberList();

        for(int i : l ){
            System.out.print(i + " ");
        }

    }




}
