package flash.card.java.model;

import flash.card.java.interfaces.QuizInterface;

public class Quiz implements QuizInterface{

    private int quizID;
    private Deck deck;
    private User owner;
    private String title;
    private String description;
    
    public Quiz(int quizID, String title, String description, Deck d) {
        this.quizID = quizID;
        this.title = title;
        this.description = description;
        this.deck = d;
    }

    @Override
    public int getQuizID() {
        
        return this.quizID;
    }

    @Override
    public boolean setOwner(User u) {
        if(this.owner == null) {
            this.owner = u;
            return true;
        } else { 
            return false;
        }
        
    }

    
}
