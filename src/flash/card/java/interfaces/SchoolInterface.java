package flash.card.java.interfaces;

import java.util.List;

import flash.card.java.model.Quiz;
import flash.card.java.model.Result;

public interface SchoolInterface {
    //Iteration 1:
    boolean createTeacher (String userID, String pass, String name);
    boolean createStudent (String userID, String pass, String name);
    boolean login (String userID, String pass);
    boolean logout ();
    boolean createDeck (int deckID, String title, String description);
    boolean createCard (int cardID, String front, String back, int deckID);
    boolean deleteCard(int cardID, int deckID);
    boolean createQuiz (int quizID, String title, String description, int deckID);
    boolean createCourse (int courseID, String title);
    boolean addQuizToStudent (String userID, int quizID);
    boolean removeQuizFromStudent (String userID, int quizID);
    //Iteration 2:
    boolean editCourseName(int courseID, String courseName);
    boolean editDeckTitle(int deckID, String deckTitle);
    boolean editQuizTitle(int quizID, String quizTitle);
    boolean addStudentToCourse(int courseID, String studentID);
    boolean removeStudentFromCourse(int courseID, String studentID);
    boolean deleteStudent(String studentID);
    boolean deleteCourse(int courseID);
    boolean deleteTeacher(String teacherID);
    boolean deleteDeck(int deckID);
    boolean deleteQuiz(int quizID);
    Quiz startQuiz(int quizID);
    boolean endQuiz(int quizID, Result result);
    Result retrieveResults(int quizID);
    List<Result> retrieveAllResults(int quizID);
    //Iteration 3:
    boolean editCardFront(int deckID, int cardID, String front);
    boolean editCardBack(int deckID, int cardID, String back);
    boolean editStudentName(String studentID, String name);
    boolean editStudentPassword(String studentID, String password);
    boolean editTeacherName(String teacherID, String name);
    boolean editTeacherPassword(String teacherID, String password);
}
