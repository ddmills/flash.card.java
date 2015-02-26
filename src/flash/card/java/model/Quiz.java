package flash.card.java.model;

import flash.card.java.interfaces.QuizInterface;

public class Quiz implements QuizInterface{

    private int quizID;
    private Deck deck;
    
    @Override
    public int getQuizID() {
        
        return this.quizID;
    }

    
}
