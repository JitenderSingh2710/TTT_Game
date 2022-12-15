package com.jitenderbairwa.tic_tac_toe;

public class player {
    //player class use to get and set the player Id and player name  of the player
    private char symbol;
    private String playerName;

    public player(String name ,char symbol) {
        this.playerName=name;
        this .symbol=symbol;
    }

    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        if(symbol!='\0')
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        if(playerName!=null)
        this.playerName = playerName;
    }
}

