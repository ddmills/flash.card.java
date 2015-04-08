package flash.card.java.interfaces;

import flash.card.java.model.Card;
import flash.card.java.model.Student;

public interface ResultInterface {
    int getResultID ();
    String getAnswer();
    String getCorrect();
    Student getStudent();
    Card getCard();
}
