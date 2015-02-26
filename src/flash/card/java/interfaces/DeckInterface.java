package flash.card.java.interfaces;

import flash.card.java.model.Card;

public interface DeckInterface {
    int getDeckID ();
    Card addCard (String title, String description);
    boolean removeCard (int cardID);
}
