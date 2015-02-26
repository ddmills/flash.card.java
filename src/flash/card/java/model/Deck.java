package flash.card.java.model;


import java.util.HashMap;

import flash.card.java.interfaces.DeckInterface;

public class Deck implements DeckInterface{

    private int deckID;
    private String title;
    private String description;
    private HashMap<Integer, Card> cardList;
    
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

    public Card getCard(int cardID) {
        
        return this.cardList.get(cardID);
    }

}
