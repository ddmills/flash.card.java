package flash.card.java.interfaces;

import flash.card.java.model.Course;
import flash.card.java.model.Deck;
import flash.card.java.model.Principal;
import flash.card.java.model.Quiz;
import flash.card.java.model.Student;
import flash.card.java.model.Teacher;
import flash.card.java.model.User;

public interface DatabaseSupportInterface {
    //Iteration 1:
    User getUser(String userID);
    Student getStudent(String studentID);
    boolean putStudent(Student s);
    boolean putTeacher(Teacher t);
    boolean putPrincipal(Principal p);
    boolean putCourse(Course c);
    Deck getDeck(int deckID);
    boolean putDeck(Deck d);
    Quiz getQuiz(int quizID);
    boolean putQuiz(Quiz q);
    //Iteration 2:
    Course getCourse(int courseID);
    Teacher getTeacher(String teacherID);
    boolean deleteDeck(int deckID);
    boolean deleteQuiz(int quizID);
    boolean deleteCourse(int courseID);
    boolean deleteStudent(String studentID);
    boolean deleteTeacher(String teacherID);
}
