package com.ecsimsw.baseball.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String ASK_NUMBER = "숫자를 입력해주세요 : ";
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String askNumber() {
        System.out.println(ASK_NUMBER);
        String inputString = "";

        try{
            inputString = bufferedReader.readLine();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return inputString;
    }
}
