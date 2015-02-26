package flash.card.java.model;

public class Teacher extends User {

    public Teacher(String userID, String pass, String name) {
        super(userID, pass, name);
        this.accessLevel = AccessLevel.teacher;
    }

}
