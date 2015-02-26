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
        if (user.isSet()) {
            if (user.get().access() == AccessLevel.principal) {
                Teacher t = new Teacher(name, userID, pass);
                return db.putTeacher(t);
            }
        }
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
    public boolean createDeck(int deckID, String title, String description) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = new Deck(deckID, title, description);
                d.setOwner(this.user.get());
                return db.putDeck(d);
            }
        }
        return false;
        
    }

    @Override
    public boolean createCard(int cardID, String front, String back, int deckID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                d.addCard(cardID, front, back);
                return db.putDeck(d);
            }
        }
        return false;
        
    }

    @Override
    public boolean removeCard(int cardID, int deckID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                Card c = d.getCard(cardID);
                d.removeCard(c);
                return db.putDeck(d);
            }
        }
        return false;
        
    }

    @Override
    public boolean createQuiz(int quizID, String title, String description, int deckID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                Quiz q = new Quiz(quizID, title, description, d);
                q.setOwner(this.user.get());
                return db.putQuiz(q);
            }
        }
        return false;
        
    }

    @Override
    public boolean addAllStudentsToQuiz(String quizID) {
        // Add course object type
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addStudentToQuiz(String userID, String quizID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Student s = db.getStudent(userID);
                Quiz q = db.getQuiz(quizID);
                s.addQuiz(q);
        
                return this.db.putStudent(s);
            }
        }
        return false;
        
    }

    @Override
    public boolean removeAllStudentsFromQuiz(String quizID) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeStudentFromQuiz(String userID, String quizID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Student s = db.getStudent(userID);
                Quiz q = db.getQuiz(quizID);
                s.removeQuiz(q);
        
                return this.db.putStudent(s);
            }
        }
        return false;
        
    }

}
