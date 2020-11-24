package com.ecsimsw.baseball.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String ASK_NUMBER = "숫자를 입력해주세요 : ";
    private static final String ASK_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String askNumber() {
        System.out.println(ASK_NUMBER);
        return inputLine();
    }

    public static String askAgain(){
        System.out.println(ASK_AGAIN);
        return inputLine();
    }

    private static String inputLine(){
        String inputString = "";
        try{
            inputString = bufferedReader.readLine();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return inputString;
    }
}
