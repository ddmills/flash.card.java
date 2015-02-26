package flash.card.java.controller;

import flash.card.java.interfaces.SchoolControllerInterface;
import flash.card.java.model.School;

public class SchoolController implements SchoolControllerInterface {

    School school;
    
    public SchoolController() {
        school = new School();
    }
    
    @Override
    public int createTeacher(String name, String userID, String pass) {
        return school.createTeacher(name, userID, pass);
    }

    @Override
    public int addStudent(String name, String userID, String pass) {
        return school.addStudent(name, userID, pass);
    }

    @Override
    public boolean login(String userID, String pass) {
        return school.login(userID, pass);
    }

    @Override
    public boolean logout() {
        return school.logout();
    }

    @Override
    public int createDeck(String title, String description) {
        return school.createDeck(title, description);
    }

    @Override
    public int addCard(String front, String back, int deckID) {
        return school.addCard(front, back, deckID);
    }

    @Override
    public boolean removeCard(int cardID, int deckID) {
        return school.removeCard(cardID, deckID);
    }

    @Override
    public int createQuiz(String title, String description, int deckID) {
        return school.createQuiz(title, description, deckID);
    }

    @Override
    public boolean addAllStudentsToQuiz(String quizID) {
        return school.addAllStudentsToQuiz(quizID);
    }

    @Override
    public boolean addStudentToQuiz(String userID, String quizID) {
        return school.addStudentToQuiz(userID, quizID);
    }

    @Override
    public boolean removeAllStudentsFromQuiz(String quizID) {
        return school.removeAllStudentsFromQuiz(quizID);
    }

    @Override
    public boolean removeStudentFromQuiz(String userID, String quizID) {
        return school.removeStudentFromQuiz(userID, quizID);
    }
}
