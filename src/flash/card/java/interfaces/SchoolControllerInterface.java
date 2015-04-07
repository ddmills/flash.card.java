package flash.card.java.interfaces;

import java.util.List;

public interface SchoolControllerInterface {
    //Iteration 1:
    boolean createTeacher (String name, String userID, String pass);
    boolean createStudent (String name, String userID, String pass);
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
    boolean editQuizTitle(int quizID, String quizTitle);
    boolean addStudentToCourse(int courseID, String studentID);
    boolean removeStudentFromCourse(int courseID, String studentID);
    boolean deleteStudent(String studentID);
    boolean deleteCourse(int courseID);
    boolean deleteTeacher(String teacherID);
    boolean deleteDeck(int deckID);
    boolean deleteQuiz(int quizID);
    boolean startQuiz(int quizID);
    boolean answerQuestion(int cardID, String answer);
    List<String> retrieveResults(int quizID);
    List<String> retrieveAllResults(int quizID);
}
