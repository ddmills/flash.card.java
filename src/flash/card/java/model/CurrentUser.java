package flash.card.java.model;

import flash.card.java.interfaces.CurrentUserInterface;

/*
 * CurrentUser Singleton
 */
public class CurrentUser implements CurrentUserInterface {
    private static CurrentUser instance = null;
    private User user;
    
    @Override
    public User set(User user) {
        this.user = user;
        return this.user;
    }
    
    @Override
    public User get() {
        return this.user;
    }
    
    @Override
    public boolean isSet() {
        return this.user != null;
    }
    
    @Override
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
