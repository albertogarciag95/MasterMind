package com.mastermind;

import com.mastermind.controllers.local.*;
import com.mastermind.models.Game;

public class Logic {

    private Game game;

    private LocalTurnControllerBuilder turnControllerBuilder;

    private LocalSecretController secretController;

    private LocalStartController startController;

    private LocalWinningController winningController;


    public Logic() {
        game = new Game();
        turnControllerBuilder = new LocalTurnControllerBuilder(game);
        secretController = new LocalSecretController(game, turnControllerBuilder);
        startController = new LocalStartController(game);
    }

    public LocalOperationController getController() {
        switch (game.getState()){
            case OPTIONS:
                return startController;
            case SECRET:
                return secretController;
            case TURN:
                return turnControllerBuilder.getTurnController();
            case FINAL:
                return winningController;
            default:
                return null;
        }
    }
}
