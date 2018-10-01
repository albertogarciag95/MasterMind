package com.mastermind.views;

import com.mastermind.controllers.*;
import com.mastermind.controllers.local.*;
import com.mastermind.models.State;
import com.mastermind.models.Turn;

public class MasterMindView implements OperationControllerVisitor {
    public void interact(OperationController operationController) {
        assert operationController != null;
        operationController.accept(this);
    }

    @Override
    public void visit(LocalStartController startController) {
        assert startController != null;
        OptionsView optionsView = new OptionsView();
        optionsView.writeOptions();
        startController.setNumOption(optionsView.getOption());
        startController.nextState();
    }

    @Override
    public void visit(LocalSecretController secretController) {
        assert secretController != null;
        SecretView secretView = new SecretView();
        String secret = "";
        if(secretController.getOption() == 1) {
            secret = secretView.writeSecret();
        }
        else {
            secret = secretController.getRandomSecret();
            secretView.write("Secreto: " + secret);
            secretView.write("\n");
        }

        secretController.setGameSecret(new Turn(secret));
        secretController.nextState();
    }

    @Override
    public void visit(LocalPlayerTurnController playerTurnController) {
        PlayerTurnView playerTurnView = new PlayerTurnView();
        int attempts = 0;
        do {
            playerTurnController.setCurrentTurn(playerTurnView.readTurn());
            playerTurnController.setTurnResult(playerTurnController.getGameSecret());
            attempts ++;
            playerTurnView.writeln("Te quedan : " + String.valueOf(playerTurnController.MAX_ATTEMPTS - attempts) + " intentos");

        } while(attempts < playerTurnController.MAX_ATTEMPTS &&
                !playerTurnController.isWinningTurn());
        playerTurnController.setState(State.FINAL);
    }

    @Override
    public void visit(LocalRandomTurnController randomTurnController) {
        PlayerTurnView playerTurnView = new PlayerTurnView();
        int attempts = 0;
        do {
            String randomTurn = randomTurnController.readRandomTurn();
            randomTurnController.setCurrentTurn(randomTurn);
            randomTurnController.setTurnResult(randomTurnController.getGameSecret());
            attempts ++;
            playerTurnView.writeln("Te quedan : " + String.valueOf(randomTurnController.MAX_ATTEMPTS - attempts) + " intentos");

        } while(attempts < randomTurnController.MAX_ATTEMPTS &&
                !randomTurnController.isWinningTurn());
        randomTurnController.setState(State.FINAL);

    }

}
