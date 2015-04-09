package flash.card.java.interfaces;

import flash.card.java.model.Student;

public interface AnswerInterface {
    int getAnswerID();
    String getQuestion();
    String getExpectedAnswer();
    String getActualAnswer();
}
