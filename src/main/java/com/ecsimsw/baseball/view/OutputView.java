package com.ecsimsw.baseball.view;

public class OutputView {
    private static final String INVALID_INPUT = "잘못된 입력입니다.";
    private static final String announce_STRIKE = "스트라이크";
    private static final String announce_BALL = "볼";
    private static final String announce_NOTHING = "낫싱";
    private static final String announce_ALL_CORRECT = "개의 숫자 모두 맞히셨습니다! ";
    private static final String announce_GAME_END = "게임 종료";

    public static void invalidInput(){
        System.out.println(INVALID_INPUT);
    }

    public static void announceScore(int strikeCnt, int ballCnt){
        if(strikeCnt ==0 && ballCnt ==0){
            announceNothing();
        }
        if(strikeCnt != 0){
            announceStrike(strikeCnt);
        }
        if(ballCnt != 0){
            announceBall(ballCnt);
        }
        System.out.println();
    }
    private static void announceNothing(){
        System.out.print(announce_NOTHING);
    }

    private static void announceStrike(int strikeCnt){
        System.out.print(strikeCnt + announce_STRIKE);
    }

    private static void announceBall(int ballCnt){
        System.out.print(ballCnt + announce_BALL);
    }

    public static void announceAllCorrect(int ballCnt){
        System.out.print(ballCnt + announce_ALL_CORRECT);;
    }

    public static void announceGameEnd(){
        System.out.print(announce_GAME_END);
    }
}
