package flash.card.java.model;

import flash.card.java.interfaces.ResultInterface;

public class Result implements ResultInterface {

    private String resultID;
    private int score;
    private Student student;
    
    public Result (int quizID, Student student) {
        this.resultID = quizID + student.getUserID();
        this.score = 0;
        this.student = student;
    }
    
    @Override
    public String getResultID() {
        return this.resultID;
    }
    
    @Override
    public int getScore() {
        return this.score;
    }
    
    @Override
    public Student getStudent() {
        return this.student;
    }
}
