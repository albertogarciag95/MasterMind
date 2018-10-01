package com.mastermind.controllers.local;

import com.mastermind.controllers.OperationControllerVisitor;
import com.mastermind.controllers.StateController;
import com.mastermind.models.Game;
import com.mastermind.models.State;

public class LocalStartController extends LocalOperationController implements
        StateController {

    private LocalSecretController secretController;

    public LocalStartController(Game game) {
        super(game);
        assert secretController != null;
        this.secretController = secretController;
    }

    @Override
    public void nextState() {
        assert this.getState() == State.OPTIONS;
        this.setState(State.SECRET);
    }

    public void setNumOption(int option) {
        this.setOption(option);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
