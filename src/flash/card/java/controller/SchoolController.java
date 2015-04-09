package flash.card.java.controller;

import java.util.List;

import flash.card.java.interfaces.SchoolControllerInterface;
import flash.card.java.model.Quiz;
import flash.card.java.model.Result;
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
    public boolean deleteCard(int cardID, int deckID) {
        return school.deleteCard(cardID, deckID);
    }

    @Override
    public boolean createQuiz(int quizID, String title, String description, int deckID) {
        return school.createQuiz(quizID, title, description, deckID);
    }

    @Override
    public boolean addQuizToStudent(String userID, int quizID) {
        return school.addQuizToStudent(userID, quizID);
    }

    @Override
    public boolean removeQuizFromStudent(String userID, int quizID) {
        return school.removeQuizFromStudent(userID, quizID);
    }

    @Override
    public boolean createCourse(int courseID, String title) {
        return school.createCourse(courseID, title);
    }

    @Override
    public boolean editCourseName(int courseID, String courseName)
    {
        return school.editCourseName(courseID, courseName);
    }

    @Override
    public boolean editDeckTitle(int deckID, String deckTitle)
    {
        return school.editDeckTitle(deckID, deckTitle);
    }

    @Override
    public boolean editQuizTitle(int quizID, String quizTitle)
    {
        return school.editQuizTitle(quizID, quizTitle);
    }

    @Override
    public boolean addStudentToCourse(int courseID, String studentID)
    {
        return school.addStudentToCourse(courseID, studentID);
    }

    @Override
    public boolean removeStudentFromCourse(int courseID, String studentID)
    {
        return school.removeStudentFromCourse(courseID, studentID);
    }

    @Override
    public boolean deleteStudent(String studentID)
    {
        return school.deleteStudent(studentID);
    }

    @Override
    public boolean deleteCourse(int courseID)
    {
        return school.deleteCourse(courseID);
    }

    @Override
    public boolean deleteTeacher(String teacherID)
    {
        return school.deleteTeacher(teacherID);
    }

    @Override
    public boolean deleteDeck(int deckID)
    {
        return school.deleteDeck(deckID);
    }

    @Override
    public boolean deleteQuiz(int quizID)
    {
        return school.deleteQuiz(quizID);
    }
    
    @Override
    public Quiz startQuiz(int quizID)
    {
        return school.startQuiz(quizID);
    }
    
    @Override
    public boolean endQuiz(int quizID, Result results)
    {
        return school.endQuiz(quizID, results);
    }
    
    @Override
    public List<String> retrieveResults(int quizID)
    {
        return school.retrieveResults(quizID);
    }
    
    @Override
    public List<String> retrieveAllResults(int quizID)
    {
        return school.retrieveAllResults(quizID);
    }
}
