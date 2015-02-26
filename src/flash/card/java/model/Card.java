package flash.card.java.model;

import flash.card.java.interfaces.CardInterface;

public class Card implements CardInterface{

    private int cardID;
    private String front;
    private String back;
    
    public Card (int id, String front, String back) {
        this.cardID = id;
        this.front = front;
        this.back = back;
    }
    
    @Override
    public int getCardID() {
        return this.cardID;
    }
    
    
    

}
