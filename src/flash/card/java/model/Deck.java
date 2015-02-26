package flash.card.java.model;

import java.util.ArrayList;

import flash.card.java.interfaces.DeckInterface;

public class Deck implements DeckInterface{

    private int deckID;
    private ArrayList<Card> cardList;
    
    public Deck (int deckID) {
        this.deckID = deckID;
        this.cardList = new ArrayList<Card>();
    }
    
    public Deck (int deckID, ArrayList<Card> cardList) {
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
        return this.cardList.add(c);
    }

    @Override
    public boolean removeCard(Card c) {
        
        return this.cardList.remove(c);
    }

}
