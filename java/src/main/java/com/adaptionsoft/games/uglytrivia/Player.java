package com.adaptionsoft.games.uglytrivia;

public class Player {
    public final String name;
    private int location;
    private int goldCoins;

    public Player(String name) {
        this.name = name;
    }

    public void move(int roll) {
        location += roll;
        if (location > 11) location = location - 12;
    }

    public int getLocation() {
        return location;
    }

    public void winAGoldCoin() {
        goldCoins++;
        System.out.println(name
                + " now has "
                + goldCoins
                + " Gold Coins.");
    }

    public boolean hasPlayerWon() {
        return goldCoins == 6;
    }
}
