package com.mastermind.controllers.local;

import com.mastermind.controllers.OperationControllerVisitor;
import com.mastermind.models.Game;
import com.mastermind.models.Token;
import com.mastermind.models.Turn;
import com.mastermind.utils.IO;

import java.io.IOException;
import java.util.Random;

public class LocalRandomTurnController extends LocalTurnController {

    public final int LENGHT_SECRET = 4;
    private String currentTurn;

    LocalRandomTurnController(Game game) {
        super(game);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        assert operationControllerVisitor != null;
        operationControllerVisitor.visit(this);
    }

    public String readRandomTurn() {
        String[] colorArray = Token.tokenColors;
        String randomWinningTurn = "";

        for(int i = LENGHT_SECRET; i > 0 ; i--) {
            Random random = new Random();
            int randomIndex = random.nextInt(colorArray.length);
            randomWinningTurn = randomWinningTurn + colorArray[randomIndex];
        }

        this.writeln("Intento? (pulsa enter para que avance la demo): " + randomWinningTurn);
        return randomWinningTurn;
    }

    public void setCurrentTurn(String turnColors) {
        currentTurn = turnColors;
    }


    public void writeln(String title) {
        try {
            IO io = new IO();
            io.writeln(title);
            System.in.read();
        }
        catch(IOException ex) {
            ex.getMessage();
        }
    }

    public void setTurnResult(Turn winningTurn) {
        Turn actualTurn = new Turn(currentTurn);
        String winningColors = winningTurn.getTurnColors();

        int deadTokens = actualTurn.getDeadTokens(winningColors);
        int injuredTokens = actualTurn.getInjuredTokens(winningColors);

        this.writeln(deadTokens + " muertos y " + injuredTokens + " heridos");
    }

    public boolean isWinningTurn() {
        Turn actualTurn = new Turn(currentTurn);
        return actualTurn.getResult().isWinningTurn();
    }
}
