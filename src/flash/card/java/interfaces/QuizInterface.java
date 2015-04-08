package flash.card.java.interfaces;

import java.util.HashMap;
import java.util.List;

import flash.card.java.model.Deck;
import flash.card.java.model.Student;
import flash.card.java.model.User;
import flash.card.java.model.Result;

public interface QuizInterface {
    //Iteration 1:
    int getQuizID();
    boolean setOwner(User u);
    Deck getDeck();
    User getOwner();
    String getTitle();
    String getDescription();
    //Iteration 2:
    boolean setQuizTitle(String quizTitle);
    boolean userOwnsQuiz(User u);
    boolean answerQuestion(int cardID, String answer, Student s);
    List<String> retrieveResults(Student s);
    List<String> retrieveAllResults();
    HashMap<Integer, Result> getResults();
    void setResults(HashMap<Integer, Result> resultList);
}
