package flash.card.java.model;

import flash.card.java.interfaces.CurrentQuizInterface;

/*
 * CurrentUser Singleton
 */
public class CurrentQuiz implements CurrentQuizInterface {
    private static CurrentQuiz instance = null;
    private Quiz quiz;
    
    @Override
    public Quiz set(Quiz quiz) {
        this.quiz = quiz;
        return this.quiz;
    }
    
    @Override
    public Quiz get() {
        return this.quiz;
    }
    
    @Override
    public boolean isSet() {
        return this.quiz != null;
    }
    
    @Override
    public boolean unset() {
        if (this.isSet()) {
            this.quiz = null;
            return true;
        }
        return false;
    }
    
    public static CurrentQuiz getInstance() {
        if (instance == null) {
            instance = new CurrentQuiz();
        }
        return instance;
    }
}
