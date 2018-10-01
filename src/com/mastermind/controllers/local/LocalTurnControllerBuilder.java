package com.mastermind.controllers.local;

import com.mastermind.models.Game;

public class LocalTurnControllerBuilder {

    private LocalTurnController localTurnController;

    private Game game;

    public LocalTurnControllerBuilder(Game game) {
        this.game = game;
    }

    public void build(int option) {
        if(option == 1) {
            localTurnController = new LocalPlayerTurnController(game);
        }
        if(option == 2) {
            localTurnController = new LocalRandomTurnController(game);
        }
    }

    public LocalTurnController getTurnController() {
        return localTurnController;
    }
}
