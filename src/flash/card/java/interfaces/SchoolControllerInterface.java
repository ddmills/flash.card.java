package flash.card.java.interfaces;

public interface SchoolControllerInterface {
    boolean createTeacher (String name, String userID, String pass);
    boolean createStudent (String name, String userID, String pass);
    boolean login (String userID, String pass);
    boolean logout ();
    
    boolean createDeck (int deckID, String title, String description);
    boolean createCard (int cardID, String front, String back, int deckID);
    boolean removeCard(int cardID, int deckID);
    boolean createQuiz (int quizID, String title, String description, int deckID);
    boolean createCourse (int courseID, String title);
    
    boolean addAllStudentsToQuiz (int quizID);
    boolean addStudentToQuiz (String userID, int quizID);
    boolean removeAllStudentsFromQuiz (int quizID);
    boolean removeStudentFromQuiz (String userID, int quizID);
}
