package flash.card.java.interfaces;

public interface CardInterface {
    int getCardID ();
    String getFront();
    String getBack();
    boolean setFront(String front);
    boolean setBack(String back);
}
