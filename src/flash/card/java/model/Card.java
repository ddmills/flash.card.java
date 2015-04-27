package flash.card.java.model;

import flash.card.java.interfaces.CardInterface;

public class Card implements CardInterface {

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
    
    @Override
    public String getFront() {
        return front;
    }
    
    @Override
    public String getBack() {
        return back;
    }

    @Override
    public boolean setFront(String front)
    {
        this.front = front;
        return true;
    }

    @Override
    public boolean setBack(String back)
    {
        this.back = back;
        return true;
    }
}
