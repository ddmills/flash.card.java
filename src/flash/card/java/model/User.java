package flash.card.java.model;

public abstract class User {
    String userID;
    String password;
    AccessLevel accessLevel;
    
    boolean comparePassword(String password) {
        return this.password.equals(password);
    }
}
