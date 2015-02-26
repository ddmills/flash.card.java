package flash.card.java.interfaces;

public interface SchoolControllerInterface {
    int createTeacher (String name, String userID, String pass);
    int addStudent (String name, String userID, String pass);
    boolean login (String userID, String pass);
    void logout ();
    
    int createDeck (String title, String description);
    int addCard (String front, String back, int deckID);
    boolean removeCard(int cardID, int deckID);
    int createQuiz (String title, String description, int deckID);
    
    boolean addAllStudentsToQuiz (String quizID);
    boolean addStudentToQuiz (String userID, String quizID);
    boolean removeAllStudentsFromQuiz (String quizID);
    boolean removeStudentFromQuiz (String userID, String quizID);
}
