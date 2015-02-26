package flash.card.java.model;

import java.util.ArrayList;

public class Principal extends User {
    String name;
    
    public Principal(String name, String userID, String pass) {
        this.name = name;
        this.userID = userID;
        this.password = pass;
        this.accessLevel = AccessLevel.principal;
    }

}
