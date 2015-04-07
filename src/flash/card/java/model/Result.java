package flash.card.java.model;

import flash.card.java.interfaces.ResultInterface;

public class Result implements ResultInterface {

    private int resultID;
    private String answer;
    private Student student;
    
    public Result (int id, String answer, Student student) {
        this.resultID = id;
        this.answer = answer;
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
    public Student getStudent() {
        return this.student;
    }
}
