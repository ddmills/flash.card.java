package flash.card.java.db;

import flash.card.java.model.Card;
import flash.card.java.model.Deck;
import flash.card.java.model.Quiz;
import flash.card.java.model.Student;
import flash.card.java.model.User;

public class DatabaseSupport implements DatabaseSupportInterface {

    @Override
    public boolean confirmCredentials(int userID, String pass) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public User getUser(String userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Student getStudent(String studentID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putStudent(Student s) {
        // TODO Auto-generated method stub

    }

    @Override
    public Deck getDeck(int deckID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putDeck(Deck d) {
        // TODO Auto-generated method stub

    }

    @Override
    public Card putCard(Card c) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeCard(Deck d, Card c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Quiz getQuiz(String quizID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean putQuiz(Quiz q) {
        // TODO Auto-generated method stub
        return false;
    }

}
