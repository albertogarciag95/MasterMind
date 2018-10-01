package com.mastermind.models;

public class Game {
    private State state;
    private int option;
    private Turn secret;

    public Game() {
        state = State.OPTIONS;
    }

    public State getState() {
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public void setGameSecret(Turn secret) {
        this.secret = secret;
    }
    public Turn getSecret() {
        return secret;
    }

}
