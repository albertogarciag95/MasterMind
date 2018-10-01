package com.mastermind.controllers.local;

import com.mastermind.models.Game;

public abstract class LocalTurnController extends LocalOperationController {

    public int MAX_ATTEMPTS = 10;

    protected LocalTurnController(Game game) {
        super(game);
    }

}
