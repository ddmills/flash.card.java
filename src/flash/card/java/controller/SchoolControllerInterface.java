package flash.card.java.controller;

public interface SchoolControllerInterface {
    int createTeacher (String name, String pass);
    int addStudent (String name, String pass);
    boolean login (int userID, String pass);
    void logout ();
    
    int createDeck (String title, String description);
    int addCard (String front, String back, int deckID);
    boolean removeCard(int cardID, int deckID);
    int createQuiz (String title, String description, int deckID);
    
    boolean addAllStudentsToQuiz (String quizID);
    boolean addStudentToQuiz (String studentID, String quizID);
    boolean removeAllStudentsFromQuiz (String quizID);
    boolean removeStudentFromQuiz (String studentID, String quizID);
}
