package flash.card.java.model;

import flash.card.java.db.DatabaseSupport;
import flash.card.java.interfaces.SchoolInterface;

public class School implements SchoolInterface {

    CurrentUser user;
    DatabaseSupport db = null;
    
    public School() {
        this.user = new CurrentUser();
        this.db = DatabaseSupport.getInstance();
    }
    
    
    @Override
    public boolean createTeacher(String name, String userID, String pass) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean createStudent(String name, String userID, String pass) {
        Student s = new Student(name, userID, pass);
        
        return this.db.putStudent(s);
    }

    @Override
    public boolean login(String userID, String pass) {
        if (!user.isSet()) {
            try {
                User provided;
                provided = db.getUser(userID);
                if (provided.comparePassword(pass)) {
                    user.set(provided);
                    return true;
                }
            } catch(Exception e) {}
        }
        return false;
    }

    @Override
    public boolean logout() {
        return user.unset();
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
        
        return this.db.putStudent(s);
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
        
        return this.db.putStudent(s);
    }

}
