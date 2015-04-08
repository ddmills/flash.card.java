package flash.card.java.model;

import flash.card.java.interfaces.ResultInterface;

public class Result implements ResultInterface {

    private int resultID;
    private String answer;
    private Card card;
    private Student student;
    private String correct;
    
    public Result (int id, String answer, String correct, Card card, Student student) {
        this.resultID = id;
        this.answer = answer;
        this.correct = correct;
        this.card = card;
        this.student = student;
    }
    
    @Override
    public int getResultID() {
        return this.resultID;
    }
    
    @Override
    public String getAnswer() {
        return this.answer;
    }
    
    @Override
    public String getCorrect() {
        return this.correct;
    }
    
    @Override
    public Student getStudent() {
        return this.student;
    }
    
    @Override
    public Card getCard() {
        return this.card;
    }
}
