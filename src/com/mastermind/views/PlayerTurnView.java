package com.mastermind.views;

import com.mastermind.utils.IO;

public class PlayerTurnView {

    private final String SECRET_PATTERN = "[ARVZBN]{4}";

    public PlayerTurnView() {}

    public void write(String title) {
        IO io = new IO();
        io.write(title);
    }

    public void writeln(String title) {
        IO io = new IO();
        io.writeln(title);
    }

    public String readTurn() {
        IO io = new IO();
        String turn = io.readString(SECRET_PATTERN, "Intento?:");

        return turn;
    }
}
