package com.adaptionsoft.games.uglytrivia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Questions {
    private final Map<Integer, LinkedList<Question>> elements = new HashMap<>();

    public Questions() {
        elements.put(0, new LinkedList<>());
        elements.put(1, new LinkedList<>());
        elements.put(2, new LinkedList<>());
        elements.put(3, new LinkedList<>());
        for (int i = 0; i < 50; i++) {
            elements.get(0).addLast(new Question(QuestionCategoryEnum.POP, "Pop Question " + i));
            elements.get(1).addLast(new Question(QuestionCategoryEnum.SCIENCE, "Science Question " + i));
            elements.get(2).addLast(new Question(QuestionCategoryEnum.SPORTS, "Sports Question " + i));
            elements.get(3).addLast(new Question(QuestionCategoryEnum.ROCK, "Rock Question " + i));
        }
    }

    public Question drawQuestion(int location) {
        return elements.get(location % 4).removeFirst();
    }
}
