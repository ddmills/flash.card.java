package flash.card.java.interfaces;

import java.util.HashMap;

import flash.card.java.model.Quiz;

public interface StudentInterface {
    String getUserID ();
    boolean addQuiz (Quiz q);
    boolean removeQuiz (Quiz q);
    boolean checkListOfQuizzes(Quiz q);
    HashMap<Integer, Quiz> getQuizzes();
}
