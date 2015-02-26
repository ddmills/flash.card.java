package flash.card.java.interfaces;

import flash.card.java.model.Card;
import flash.card.java.model.Deck;
import flash.card.java.model.Quiz;
import flash.card.java.model.Student;
import flash.card.java.model.User;

public interface DatabaseSupportInterface {
    User getUser(String userID);
    
    Student getStudent(String studentID);
    boolean putStudent(Student s);
    
    Deck getDeck(int deckID);
    boolean putDeck(Deck d);
    
    Card putCard(Card c);
    boolean removeCard(Deck d, Card c);
    
    Quiz getQuiz(String quizID);
    boolean putQuiz(Quiz q);
}
