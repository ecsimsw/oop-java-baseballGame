package com.ecsimsw.baseball.controller;

import com.ecsimsw.baseball.domain.GameStatus;
import com.ecsimsw.baseball.domain.InputValidator;
import com.ecsimsw.baseball.view.InputView;
import com.ecsimsw.baseball.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;

public class BaseballGame {
    private final ArrayList<Integer> targetNumberList;
    private ArrayList<Integer> inputNumberList;

    private boolean isGameEnd = false;

    public BaseballGame(ArrayList<Integer> targetNumberList){
        this.targetNumberList = targetNumberList;
    }

    public void playGame() {
        while(isGameEnd){
            String inputNumber = guess();
            stringToNumberList(inputNumber);
        }
    }

    private String guess(){
        String inputNumber = InputView.askNumber();
        if(InputValidator.isValid(inputNumber)){
            OutputView.invalidInput();
            setGameEnd();
        }
        return inputNumber;
    }

    private ArrayList<Integer> stringToNumberList(String inputNumber){
        inputNumberList = new ArrayList<>();
        for(char c : inputNumber.toCharArray()){
            inputNumberList.add(Character.getNumericValue(c));
        }
        return inputNumberList;
    }

    private void setGameEnd(){
        isGameEnd = true;
    }

    private void getScore(){

    }

    private void isStrike(){
        
    }
}
