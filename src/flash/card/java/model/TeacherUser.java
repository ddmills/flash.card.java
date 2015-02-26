package flash.card.java.model;

public class TeacherUser extends User {

    String[] students;
    String[] quizzes;
    String[] decks;
    
    public TeacherUser(String username, String pass) {
        this.username = username;
        this.password = pass;
        this.accessLevel = AccessLevel.teacher;
    }
    
}
