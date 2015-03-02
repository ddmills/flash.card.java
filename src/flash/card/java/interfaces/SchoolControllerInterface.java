package flash.card.java.interfaces;

public interface SchoolControllerInterface {
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
}
