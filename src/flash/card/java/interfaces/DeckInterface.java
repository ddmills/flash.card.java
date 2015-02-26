package flash.card.java.interfaces;

import flash.card.java.model.Card;

public interface DeckInterface {
    int getDeckID ();
    boolean addCard (int cardID, String front, String back);
    boolean removeCard (Card c);
}
