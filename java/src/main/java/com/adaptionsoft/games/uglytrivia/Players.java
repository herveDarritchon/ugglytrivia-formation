package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<Player> elements = new ArrayList<>();
    private int currentPlayer;

    public void add(String playerName) {
        elements.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + elements.size());
    }

    public Player getCurrentPlayer() {
        return elements.get(currentPlayer);
    }

    public boolean switchToNextPlayer() {
        boolean winner = getCurrentPlayer().hasPlayerWon();
        currentPlayer++;
        if (currentPlayer == elements.size()) currentPlayer = 0;

        return winner;
    }
}
