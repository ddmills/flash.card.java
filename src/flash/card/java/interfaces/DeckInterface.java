package flash.card.java.interfaces;

import flash.card.java.model.Card;
import flash.card.java.model.User;

public interface DeckInterface {
    int getDeckID ();
    boolean addCard (int cardID, String front, String back);
    boolean removeCard (Card c);
    boolean setOwner (User u);
    Card getCard(int cardID);
}
