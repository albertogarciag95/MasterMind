package com.mastermind.views;

import com.mastermind.utils.IO;

public class SecretView {

    private final String SECRET_PATTERN = "[ARVZBN]{4}";

    public SecretView() {
    }

    public String writeSecret() {
        IO io = new IO();
        String secret = io.readString(SECRET_PATTERN, "Secreto? [cuatro letras de entre A-amarillo, \nR-rojo, V-verde, Z-azul, B-blanco, N-negro]:");

        return secret;
    }

    public void write(String title) {
        IO io = new IO();
        io.write(title);
    }

}
