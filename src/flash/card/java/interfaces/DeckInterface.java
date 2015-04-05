package flash.card.java.interfaces;

import java.util.HashMap;

import flash.card.java.model.Card;
import flash.card.java.model.User;

public interface DeckInterface {
    // iteration 1
    public int getDeckID ();
    public boolean createCard (int cardID, String front, String back);
    public boolean deleteCard (Card c);
    public boolean setOwner (User u);
    public Card getCard(int cardID);
    public HashMap<Integer, Card> getCards();
    public String getOwnerID();
    public String getTitle();
    public String getDescription();
    // iteration 2
    public boolean userOwnsDeck(User u);
}
