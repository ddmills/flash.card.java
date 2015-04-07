package flash.card.java.model;

import flash.card.java.interfaces.ResultInterface;

public class Result implements ResultInterface {

    private int resultID;
    private String answer;
    
    public Result (int id, String answer) {
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
}
