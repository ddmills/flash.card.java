package flash.card.java.interfaces;

public interface SchoolInterface {
    boolean createTeacher (String name, String userID, String pass);
    boolean createStudent (String name, String userID, String pass);
    boolean login (String userID, String pass);
    boolean logout ();
    
    boolean createDeck (String title, String description);
    boolean createCard (String front, String back, int deckID);
    boolean removeCard(int cardID, int deckID);
    boolean createQuiz (String title, String description, int deckID);
    
    boolean addAllStudentsToQuiz (String quizID);
    boolean addStudentToQuiz (String userID, String quizID);
    boolean removeAllStudentsFromQuiz (String quizID);
    boolean removeStudentFromQuiz (String userID, String quizID);
}
