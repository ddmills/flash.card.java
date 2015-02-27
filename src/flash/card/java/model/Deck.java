package flash.card.java.model;


import java.util.HashMap;

import flash.card.java.interfaces.DeckInterface;

public class Deck implements DeckInterface {

    private int deckID;
    private String title;
    private String description;
    private HashMap<Integer, Card> cardList;
    private User owner;
    
    public Deck (int deckID, String title, String description) {
        this.deckID = deckID;
        this.title = title;
        this.description = description;
        this.cardList = new HashMap<Integer, Card>();
    }
    
    public Deck (int deckID, HashMap<Integer, Card> cardList) {
        this.deckID = deckID;
        this.cardList = cardList;
    }
    
    public Deck (int deckID, String title, String description, User owner, HashMap<Integer, Card> cardList) {
        this.deckID = deckID;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.cardList = cardList;
    }
    
    @Override
    public int getDeckID() {
        return this.deckID;
    }

    @Override
    public boolean addCard(int cardID, String front, String back) {
        Card c = new Card(cardID, front, back);
        this.cardList.put(c.getCardID(), c);
        return true;
    }

    @Override
    public boolean removeCard(Card c) {
        return this.cardList.remove(c.getCardID(), c);
    }
    
    @Override
    public boolean setOwner(User u) {
        if(owner == null) {
            this.owner = u;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Card getCard(int cardID) {
        return this.cardList.get(cardID);
    }

}
