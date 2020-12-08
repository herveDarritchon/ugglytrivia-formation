package com.adaptionsoft.games.uglytrivia;

public class Question {
    public final QuestionCategoryEnum category;
    public final String text;

    public Question(QuestionCategoryEnum category, String text) {
        this.category = category;
        this.text = text;
    }
}
