package flash.card.java.interfaces;

import flash.card.java.model.User;

public interface CurrentUserInterface {

    public User set(User user);
    public User get();
    public boolean isSet();
    public boolean unset();

}