package com.ecsimsw.baseball.controller;

import com.ecsimsw.baseball.domain.InputValidator;
import com.ecsimsw.baseball.view.InputView;
import com.ecsimsw.baseball.view.OutputView;

import java.util.ArrayList;

public class BaseballGame {
    private static final int NUMBER_LEN = 3;

    private final ArrayList<Integer> targetNumberList;

    private boolean isGameEnd = false;

    public BaseballGame(ArrayList<Integer> targetNumberList){
        this.targetNumberList = targetNumberList;
    }

    public void playGame() {
        while(!isGameEnd){
            String inputNumber = guess();
            if(!checkValidInput(inputNumber)){
                break;
            }
            getScore(inputNumber);
        }
    }

    private String guess(){
        String inputNumber = InputView.askNumber();
        return inputNumber;
    }

    private boolean checkValidInput(String inputNumber){
        if(!InputValidator.isValidGuess(inputNumber)){
            OutputView.invalidInput();
            setGameEnd();
            return false;
        }
        return true;
    }

    private void setGameEnd(){
        isGameEnd = true;
        OutputView.announceGameEnd();
    }

    private void getScore(String inputNumber){
        ArrayList<Integer> inputNumberList = stringToNumberList(inputNumber);

        int strikeCnt = countStrike(inputNumberList);
        int ballCnt = countBall(inputNumberList);

        if(isAllCollect(strikeCnt)){
            OutputView.announceAllCorrect(strikeCnt);
            setGameEnd();
            return;
        }

        OutputView.announceScore(strikeCnt, ballCnt);
    }

    private ArrayList<Integer> stringToNumberList(String inputNumber){
        ArrayList<Integer> inputNumberList = new ArrayList<>();
        for(char c : inputNumber.toCharArray()){
            inputNumberList.add(Character.getNumericValue(c));
        }
        return inputNumberList;
    }

    private int countStrike(ArrayList<Integer> inputNumberList){
        int strikeCnt =0;
        for(int index =0; index< NUMBER_LEN; index++){
            if(inputNumberList.get(index) == targetNumberList.get(index)){
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    private int countBall(ArrayList<Integer> inputNumberList){
        int ballCnt = 0;
        for(int inputIndex=0; inputIndex<NUMBER_LEN; inputIndex++){
            for(int targetIndex =0; targetIndex<NUMBER_LEN; targetIndex++){
                if(targetIndex != inputIndex){
                    if(inputNumberList.get(inputIndex) == targetNumberList.get(targetIndex)){
                        ballCnt++;
                    }
                }
            }
        }
        return ballCnt;
    }

    private boolean isAllCollect(int strikeCnt){
        if(strikeCnt == NUMBER_LEN){
            return true;
        }
        return false;
    }
}
