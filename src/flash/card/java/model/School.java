package flash.card.java.model;

import flash.card.java.db.DatabaseSupport;
import flash.card.java.interfaces.SchoolInterface;

public class School implements SchoolInterface {

    CurrentUser user;
    DatabaseSupport db = null;
    
    private DatabaseSupport getDatabaseSupportInstance () {
        if(db == null)
        {
            db = new DatabaseSupport();
        }
        return db;
    }
    
    @Override
    public boolean createTeacher(String name, String userID, String pass) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean createStudent(String name, String userID, String pass) {
        Student s = new Student(name, userID, pass);
        
        return this.getDatabaseSupportInstance().putStudent(s);
    }

    @Override
    public boolean login(String userID, String pass) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean logout() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean createDeck(String title, String description) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean createCard(String front, String back, int deckID) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeCard(int cardID, int deckID) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean createQuiz(String title, String description, int deckID) {
        // TODO Auto-generated method stub
        return false;
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
        
        return this.getDatabaseSupportInstance().putStudent(s);
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
        
        return this.getDatabaseSupportInstance().putStudent(s);
    }

}
