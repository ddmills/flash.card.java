package flash.card.java.model;

public abstract class User {
    protected String userID;
    protected String password;
    protected String name;
    protected AccessLevel accessLevel;

    protected User(String userID, String password, String name) {
        this.userID = userID;
        this.password = password;
        this.name = name;
    }

    public boolean comparePassword(String password) {
        return this.password.equals(password);
    }
}
