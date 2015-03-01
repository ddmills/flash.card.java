package flash.card.java.interfaces;

import flash.card.java.model.Card;
import flash.card.java.model.Deck;
import flash.card.java.model.Principal;
import flash.card.java.model.Quiz;
import flash.card.java.model.Student;
import flash.card.java.model.Teacher;
import flash.card.java.model.User;

public interface DatabaseSupportInterface {
    User getUser(String userID);
    
    Student getStudent(String studentID);
    boolean putStudent(Student s);
    boolean putTeacher(Teacher t);
    boolean putPrincipal(Principal p);
    
    Deck getDeck(int deckID);
    boolean putDeck(Deck d);
    
    Quiz getQuiz(int quizID);
    boolean putQuiz(Quiz q);
}
