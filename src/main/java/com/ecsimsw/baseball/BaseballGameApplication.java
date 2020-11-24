package com.ecsimsw.baseball;

import com.ecsimsw.baseball.controller.BaseballGame;
import com.ecsimsw.baseball.domain.InputValidator;
import com.ecsimsw.baseball.domain.TargetNumberGenerator;
import com.ecsimsw.baseball.view.InputView;
import com.ecsimsw.baseball.view.OutputView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BaseballGameApplication {
    private static final String PLAY_AGAIN = "1";
    private static final String QUIT = "2";

    private static boolean applicationEnd = false;

    public static void main(String[] args) {
        startBaseballGameApp();
    }

    private static void startBaseballGameApp(){
        while(!applicationEnd){
            TargetNumberGenerator targetNumberGenerator = new TargetNumberGenerator();
            BaseballGame baseballGame = new BaseballGame(targetNumberGenerator.getTargetNumberList());
            baseballGame.playGame();
            askPlayAgain();
        }
    }

    private static void askPlayAgain(){
        String playAgainAnswer = InputView.askAgain();

        if(!InputValidator.isValidAgainAnswer(playAgainAnswer)){
            OutputView.invalidInput();
            return;
        }

        if(playAgainAnswer.equals(QUIT)){
            setApplicationEnd();
        }
    }

    private static void setApplicationEnd(){
        applicationEnd = true;
    }
}
