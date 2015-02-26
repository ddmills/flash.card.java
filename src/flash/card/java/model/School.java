package flash.card.java.model;

import flash.card.java.db.DatabaseSupport;
import flash.card.java.interfaces.SchoolInterface;

public class School implements SchoolInterface {

    CurrentUser user;
    DatabaseSupport db;
    
    @Override
    public int createTeacher(String name, String userID, String pass) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int addStudent(String name, String userID, String pass) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean login(String userID, String pass) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void logout() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int createDeck(String title, String description) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int addCard(String front, String back, int deckID) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean removeCard(int cardID, int deckID) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int createQuiz(String title, String description, int deckID) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean addAllStudentsToQuiz(String quizID) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addStudentToQuiz(String userID, String quizID) {
        
        Student s = db.getStudent(userID);
        Quiz q = db.getQuiz(quizID);
        s.addQuiz(q);
        
        return db.putStudent(s);
    }

    @Override
    public boolean removeAllStudentsFromQuiz(String quizID) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeStudentFromQuiz(String userID, String quizID) {
        
        Student s = db.getStudent(userID);
        Quiz q = db.getQuiz(quizID);
        s.removeQuiz(q);
        
        return db.putStudent(s);
    }

}
