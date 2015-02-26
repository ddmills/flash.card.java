package flash.card.java.db;

import flash.card.java.model.Card;
import flash.card.java.model.Deck;
import flash.card.java.model.Quiz;
import flash.card.java.model.Student;
import flash.card.java.model.User;

public interface DatabaseSupportInterface {
    boolean confirmCredentials (int userID, String pass);
    User getUser(String userID);
    
    Student getStudent(String studentID);
    void putStudent(Student s);
    
    Deck getDeck(int deckID);
    void putDeck(Deck d);
    
    Card putCard(Card c);
    boolean removeCard(Deck d, Card c);
    
    Quiz getQuiz(String quizID);
    boolean putQuiz(Quiz q);
}
