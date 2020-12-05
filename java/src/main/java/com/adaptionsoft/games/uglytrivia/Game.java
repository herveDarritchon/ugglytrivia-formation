package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Game {
    Players players = new Players();

    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
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
            return new Question("Pop", popQuestions.removeFirst());
        if (location % 4 == 1)
            return new Question("Science", scienceQuestions.removeFirst());
        if (location % 4 == 2)
            return new Question("Sports", sportsQuestions.removeFirst());
        else
            return new Question("Rock", rockQuestions.removeFirst());
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
