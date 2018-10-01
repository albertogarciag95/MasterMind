package com.mastermind.views;

import com.mastermind.utils.IO;
import com.mastermind.utils.LimitedIntDialog;

public class OptionsView {

    private int option;

    public OptionsView() {
    }

    public void writeOptions() {
       option = new LimitedIntDialog("Option? (1: Partida contra la máquina, 2: Demo):", 1, 2).read();
    }

    public void writeln() {
        IO io = new IO();
        io.writeln();
    }

    public int getOption() {
        return option;
    }
}
