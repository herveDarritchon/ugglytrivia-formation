package com.adaptionsoft.games.uglytrivia;

public enum QuestionCategoryEnum {
    POP("Pop"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    ROCK("Rock");

    private final String value;

    QuestionCategoryEnum(String value) {
        this.value= value;
    }

    @Override public String toString() {
        return value;
    }
}
