package flash.card.java.interfaces;

import flash.card.java.model.Deck;
import flash.card.java.model.User;

public interface QuizInterface {
    //Iteration 1:
    int getQuizID();
    boolean setOwner(User u);
    Deck getDeck();
    User getOwner();
    String getTitle();
    String getDescription();
    //Iteration 2:
    public boolean setQuizTitle(String quizTitle);
}
