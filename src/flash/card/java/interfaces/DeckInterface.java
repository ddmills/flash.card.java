package flash.card.java.interfaces;

import java.util.HashMap;

import flash.card.java.model.Card;
import flash.card.java.model.User;

public interface DeckInterface {
    public int getDeckID ();
    public boolean addCard (int cardID, String front, String back);
    public boolean removeCard (Card c);
    public boolean setOwner (User u);
    public Card getCard(int cardID);
    public HashMap<Integer, Card> getCards();
    public String getOwnerID();
    public String getTitle();
    public String getDescription();
}
