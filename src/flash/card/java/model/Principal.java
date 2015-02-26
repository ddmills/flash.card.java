package flash.card.java.model;

public class Principal extends User {

    public Principal(String userID, String pass, String name) {
        super(userID, pass, name);
        this.accessLevel = AccessLevel.principal;
    }

}
