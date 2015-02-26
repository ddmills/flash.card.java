package flash.card.java.model;

/*
 * CurrentUser Singleton
 */
public class CurrentUser {
    private static CurrentUser instance = null;
    private User user;
    
    public User set(User user) {
        this.user = user;
        return this.user;
    }
    
    public User get() {
        return this.user;
    }
    
    public boolean isSet() {
        return this.user != null;
    }
    
    public boolean unset() {
        if (this.isSet()) {
            this.user = null;
            return true;
        }
        return false;
    }
    
    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }
}
