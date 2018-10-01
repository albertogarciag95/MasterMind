package com.mastermind.controllers.local;
import com.mastermind.controllers.OperationControllerVisitor;
import com.mastermind.models.Game;
import com.mastermind.models.Turn;
import com.mastermind.utils.IO;

public class LocalPlayerTurnController extends LocalTurnController {

    private String currentTurn;

    LocalPlayerTurnController(Game game) {
        super(game);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        assert operationControllerVisitor != null;
        operationControllerVisitor.visit(this);
    }

    public void setCurrentTurn(String turnColors) {
        currentTurn = turnColors;
    }

    public void setTurnResult(Turn winningTurn) {
        Turn actualTurn = new Turn(currentTurn);
        String winningColors = winningTurn.getTurnColors();

        int deadTokens = actualTurn.getDeadTokens(winningColors);
        int injuredTokens = actualTurn.getInjuredTokens(winningColors);

        this.write(deadTokens + " muertos y " + injuredTokens + " heridos");
    }

    public void write(String title) {
        IO io = new IO();
        io.writeln(title);
    }

    public boolean isWinningTurn() {
        Turn actualTurn = new Turn(currentTurn);
        return actualTurn.getResult().isWinningTurn();
    }
}
