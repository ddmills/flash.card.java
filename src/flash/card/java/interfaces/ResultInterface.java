package flash.card.java.interfaces;

import java.util.HashMap;

import flash.card.java.model.Answer;
import flash.card.java.model.Student;

public interface ResultInterface {
    String getResultID();
    int getScore();
    Student getStudent();
    HashMap<Integer, Answer> getAnswers();
    boolean addAnswer(Answer answer);
}
