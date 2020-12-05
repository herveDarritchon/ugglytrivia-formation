package com.adaptionsoft.games.uglytrivia;

public class Player {
    public final String name;
    private int location;

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
}
