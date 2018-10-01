package com.mastermind.controllers.local;

import com.mastermind.controllers.OperationController;
import com.mastermind.controllers.OperationControllerVisitor;
import com.mastermind.models.Game;

public abstract class LocalOperationController extends LocalController
        implements OperationController {

    protected LocalOperationController(Game game) {
        super(game);
    }

    public abstract void accept(
            OperationControllerVisitor operationControllerVisitor);

}
