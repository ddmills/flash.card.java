package flash.card.java.model;

public interface DeckInterface {
    int getDeckID ();
    Card addCard (String title, String description);
    boolean removeCard (int cardID);
}
