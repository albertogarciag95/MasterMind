package com.mastermind.models;

import static com.mastermind.models.Turn.LENGHT_TOKEN_TURN;

public class TurnResult {

    private int injuredTokens;
    private int deadTokens;

    public TurnResult(int injuredTokens, int deadTokens) {
        this.injuredTokens = injuredTokens;
        this.deadTokens = deadTokens;
    }

    public int getDeadTokens() {
        return deadTokens;
    }

    public int getInjuredTokens() {
        return injuredTokens;
    }

    public void incrementDeads() {
        this.deadTokens++;
    }

    public void incrementInjures() {
        this.injuredTokens++;
    }

    public boolean isWinningTurn() {
        return (this.deadTokens == LENGHT_TOKEN_TURN && this.injuredTokens == 0);
    }
}
