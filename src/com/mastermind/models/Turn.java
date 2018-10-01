package com.mastermind.models;

import java.util.ArrayList;

public class Turn {

    public ArrayList<Token> tokens;
    public static final int LENGHT_TOKEN_TURN = 4;
    public TurnResult result;
    public ArrayList<String> deadList = new ArrayList<>();
    public ArrayList<String> injuredList = new ArrayList<>();

    public Turn() {}

    public Turn(String turn) {
        tokens = new ArrayList<>();
        for(int i = 0; i < LENGHT_TOKEN_TURN; i++) {
            Token token = new Token(turn.substring(i, i+1));
            if(token != null) {
                tokens.add(token);
            }
        }
        result = new TurnResult(0,0);
    }

    public String getTurnColors() {
        String result = "";
        for(Token token: tokens) {
            result = result + token.getColor();
        }
        return result;
    }

    public TurnResult getResult() {
        return result;
    }

    public boolean isWinningTurn() {
        return this.result.isWinningTurn();
    }

    public int getDeadTokens(String winningColors) {
        for(int i = 0; i < LENGHT_TOKEN_TURN; i++) {
            if(this.getTurnColors().substring(i, i+1).equals(winningColors.substring(i, i+1))) {
                if(!deadList.contains(this.getTurnColors().substring(i, i+1))) {
                    deadList.add(this.getTurnColors().substring(i, i + 1));
                    this.getResult().incrementDeads();
                }
            }
        }
        return this.getResult().getDeadTokens();
    }

    public int getInjuredTokens(String winningColors) {
        for(int i = 0; i < LENGHT_TOKEN_TURN; i++) {
            if(winningColors.contains(this.getTurnColors().substring(i, i+1)) && !deadList.contains(this.getTurnColors().substring(i, i+1))) {
                if(!injuredList.contains(this.getTurnColors().substring(i, i+1))) {
                    injuredList.add(this.getTurnColors().substring(i, i + 1));
                    this.getResult().incrementInjures();
                }
            }
        }
        return this.getResult().getInjuredTokens();
    }
}
