package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Game {
    Players players = new Players();

    LinkedList<Question> popQuestions = new LinkedList<>();
    LinkedList<Question> scienceQuestions = new LinkedList<>();
    LinkedList<Question> sportsQuestions = new LinkedList<>();
    LinkedList<Question> rockQuestions = new LinkedList<>();

    boolean isGettingOutOfPenaltyBox;

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(new Question("Pop", "Pop Question " + i));
            scienceQuestions.addLast(new Question("Science", "Science Question " + i));
            sportsQuestions.addLast(new Question("Sports", "Sports Question " + i));
            rockQuestions.addLast(new Question("Rock", "Rock Question " + i));
        }
    }

    public boolean add(String playerName) {
        players.add(playerName);
        return true;
    }

    public void roll(int roll) {
        System.out.println(players.getCurrentPlayer().name + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (players.getCurrentPlayer().isInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(players.getCurrentPlayer().name + " is getting out of the penalty box");
                moveAndAskQuestion(roll);
            } else {
                System.out.println(players.getCurrentPlayer().name + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            moveAndAskQuestion(roll);
        }
    }

    private void moveAndAskQuestion(int roll) {
        players.getCurrentPlayer().move(roll);
        int location = players.getCurrentPlayer().getLocation();
        System.out.println(players.getCurrentPlayer().name
                + "'s new location is "
                + location);
        Question question = drawQuestion(location);
        System.out.println("The category is " + question.category);
        System.out.println(question.text);
    }

    private Question drawQuestion(int location) {
        if (location % 4 == 0)
            return popQuestions.removeFirst();
        if (location % 4 == 1)
            return scienceQuestions.removeFirst();
        if (location % 4 == 2)
            return sportsQuestions.removeFirst();
        else
            return rockQuestions.removeFirst();
    }

    public boolean wasCorrectlyAnswered() {
        if (players.getCurrentPlayer().isInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct!!!!");
                players.getCurrentPlayer().winAGoldCoin();
            }
            return players.switchToNextPlayer();
        } else {
            System.out.println("Answer was corrent!!!!");
            players.getCurrentPlayer().winAGoldCoin();

            return players.switchToNextPlayer();
        }
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.getCurrentPlayer().name + " was sent to the penalty box");
        players.getCurrentPlayer().sendToPenaltyBox();

        return players.switchToNextPlayer();
    }
}
