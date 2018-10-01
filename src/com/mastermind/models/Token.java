package com.mastermind.models;

import java.util.Arrays;

public class Token {
    private String color;
    public static String[] tokenColors = {"A", "R", "V", "Z", "B", "N"};

    public Token(String color) {
        if(Arrays.asList(tokenColors).contains(color)) {
            this.color = color;
        }
    }

    public String getColor() {
        return this.color;
    }
}
