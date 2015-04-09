package flash.card.java.model;

import flash.card.java.interfaces.ResultInterface;

import java.util.HashMap;

public class Result implements ResultInterface {

    private String resultID;
    private int score;
    private Student student;
    private HashMap<Integer, Answer> answerList;
    
    public Result (int quizID, Student student) {
        this.resultID = quizID + student.getUserID();
        this.score = 0;
        this.student = student;
        this.answerList = new HashMap<Integer, Answer>();
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
    
    @Override
    public HashMap<Integer, Answer> getAnswers() {
        return answerList;
    }

    @Override
    public boolean addAnswer(Answer answer)
    {
        this.answerList.put(answer.getAnswerID(), answer);
        return true;
    }
}
