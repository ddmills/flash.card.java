package flash.card.java.db;

import flash.card.java.interfaces.DatabaseSupportInterface;
import flash.card.java.model.Card;
import flash.card.java.model.Deck;
import flash.card.java.model.Principal;
import flash.card.java.model.Quiz;
import flash.card.java.model.Student;
import flash.card.java.model.Teacher;
import flash.card.java.model.User;

public class DatabaseSupport implements DatabaseSupportInterface {
    private static DatabaseSupport instance = null;
    
    public static DatabaseSupport getInstance() {
        if (instance == null) {
            instance = new DatabaseSupport();
        }
        return instance;
    }

    @Override
    public User getUser(String userID) {
        if (userID.equals("admin")) {
            return new Principal("admin", "admin", "admin");
        }
        return null;
    }

    @Override
    public Student getStudent(String studentID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean putStudent(Student s) {
        return true;
    }
    
    @Override
    public boolean putPrincipal(Principal p) {
        return false;
    }
    
    @Override
    public boolean putTeacher(Teacher t) {
        return true;
    }

    @Override
    public Deck getDeck(int deckID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean putDeck(Deck d) {
        // TODO Auto-generated method stub
        return false;

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
