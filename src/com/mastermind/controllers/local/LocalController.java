package com.mastermind.controllers.local;

import com.mastermind.models.Game;
import com.mastermind.models.State;
import com.mastermind.models.Turn;

public abstract class LocalController {

    private Game game;

    protected LocalController(Game game) {
        assert game != null;
        this.game = game;
    }

    protected State getState() {
        return game.getState();
    }

    public void setState(State state) {
        assert state != null;
        game.setState(state);
    }

    public int getOption() {
        return game.getOption();
    }

    public void setOption(int option) {
        game.setOption(option);
    }

    public void setGameSecret(Turn secret) {
        game.setGameSecret(secret);
    }

    public Turn getGameSecret() {
        return game.getSecret();
    }

    //public boolean existTicTacToe() {
       // return game.existTicTacToe();
    //}

}
