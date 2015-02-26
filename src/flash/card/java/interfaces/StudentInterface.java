package flash.card.java.interfaces;

import flash.card.java.model.Quiz;

public interface StudentInterface {
    int getUserID ();
    boolean addQuiz (Quiz q);
    boolean removeQuiz(Quiz q);
}
