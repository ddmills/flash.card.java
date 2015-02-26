package flash.card.java.model;

/*
 * CurrentUser Singleton
 */
public class CurrentUser {
    private static CurrentUser instance = null;
    
    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }
}
