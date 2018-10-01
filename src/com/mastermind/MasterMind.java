package com.mastermind;

import com.mastermind.controllers.local.LocalOperationController;
import com.mastermind.views.MasterMindView;

public class MasterMind {

    private Logic logic;
    private MasterMindView view;

    public MasterMind() {
        this.logic = new Logic();
        this.view = new MasterMindView();
    }

    public void play() {
        LocalOperationController controller;
        do {
            controller = logic.getController();
            if (controller != null){
                view.interact(controller);
            }
        } while (controller != null);
    }

    public static void main(String[] args)  {
        new MasterMind().play();
    }
}
