package flash.card.java.interfaces;

import flash.card.java.model.User;

public interface QuizInterface {
    int getQuizID();
    boolean setOwner(User u);
}
