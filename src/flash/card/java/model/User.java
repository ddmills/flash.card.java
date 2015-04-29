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
    
    public AccessLevel access() {
        return this.accessLevel;
    }
    
    public String getUserID() {
        return this.userID;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
