package flash.card.java.controller;

import flash.card.java.interfaces.SchoolControllerInterface;
import flash.card.java.model.School;

public class SchoolController implements SchoolControllerInterface {

    private School school;
    
    public SchoolController() {
        school = new School();
    }
    
    @Override
    public boolean createTeacher(String name, String userID, String pass) {
        return school.createTeacher(name, userID, pass);
    }

    @Override
    public boolean createStudent(String name, String userID, String pass) {
        return school.createStudent(name, userID, pass);
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
    public boolean createDeck(int deckID, String title, String description) {
        return school.createDeck(deckID, title, description);
    }

    @Override
    public boolean createCard(int cardID, String front, String back, int deckID) {
        return school.createCard(cardID, front, back, deckID);
    }

    @Override
    public boolean removeCard(int cardID, int deckID) {
        return school.removeCard(cardID, deckID);
    }

    @Override
    public boolean createQuiz(int quizID, String title, String description, int deckID) {
        return school.createQuiz(quizID, title, description, deckID);
    }

    @Override
    public boolean addAllStudentsToQuiz(int quizID) {
        return school.addAllStudentsToQuiz(quizID);
    }

    @Override
    public boolean addStudentToQuiz(String userID, int quizID) {
        return school.addStudentToQuiz(userID, quizID);
    }

    @Override
    public boolean removeAllStudentsFromQuiz(int quizID) {
        return school.removeAllStudentsFromQuiz(quizID);
    }

    @Override
    public boolean removeStudentFromQuiz(String userID, int quizID) {
        return school.removeStudentFromQuiz(userID, quizID);
    }

    @Override
    public boolean createCourse(int courseID, String title) {
        return school.createCourse(courseID, title);
    }
}
