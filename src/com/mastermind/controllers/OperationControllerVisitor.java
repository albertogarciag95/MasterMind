package com.mastermind.controllers;

import com.mastermind.controllers.local.LocalPlayerTurnController;
import com.mastermind.controllers.local.LocalRandomTurnController;
import com.mastermind.controllers.local.LocalSecretController;
import com.mastermind.controllers.local.LocalStartController;

public interface OperationControllerVisitor {

    void visit(LocalStartController startController);

    void visit(LocalSecretController secretController);

    void visit(LocalPlayerTurnController turnController);

    void visit(LocalRandomTurnController turnController);
}
