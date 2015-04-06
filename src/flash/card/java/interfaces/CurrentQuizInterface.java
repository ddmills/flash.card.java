package flash.card.java.interfaces;

import flash.card.java.model.Quiz;

public interface CurrentQuizInterface {

    public Quiz set(Quiz quiz);
    public Quiz get();
    public boolean isSet();
    public boolean unset();

}