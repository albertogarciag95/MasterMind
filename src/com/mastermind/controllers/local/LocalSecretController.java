package com.mastermind.controllers.local;

import com.mastermind.controllers.OperationControllerVisitor;
import com.mastermind.controllers.StateController;
import com.mastermind.models.Game;
import com.mastermind.models.State;
import com.mastermind.models.Token;
import com.mastermind.models.Turn;

import java.util.Random;

public class LocalSecretController extends LocalOperationController implements StateController {

    public final int LENGHT_SECRET = 4;
    private LocalTurnControllerBuilder turnControllerBuilder;
    private Turn secret;

    public LocalSecretController(Game game, LocalTurnControllerBuilder turnControllerBuilder) {
        super(game);
        assert turnControllerBuilder != null;
        this.turnControllerBuilder = turnControllerBuilder;
        secret = new Turn();
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void nextState() {
        assert this.getState() == State.SECRET;
        turnControllerBuilder.build(this.getOption());
        this.setState(State.TURN);
    }

    public String getRandomSecret() {
        String[] colorArray = Token.tokenColors;
        String randomWinningTurn = "";

        for(int i = LENGHT_SECRET; i > 0 ; i--) {
            Random random = new Random();
            int randomIndex = random.nextInt(colorArray.length);
            randomWinningTurn = randomWinningTurn + colorArray[randomIndex];
        }
        return randomWinningTurn;
    }

    public void setSecret(Turn secret) {
        this.setGameSecret(secret);
    }
}
