package flash.card.java.model;

import flash.card.java.interfaces.AnswerInterface;

public class Answer implements AnswerInterface
{
    private int answerID;
    private String resultID;
    private String question;
    private String expectedAnswer;
    private String actualAnswer;
    
    public Answer(int answerID, String resultID, String question, String expectedAnswer, String actualAnswer)
    {
        this.answerID = answerID;
        this.resultID = resultID;
        this.question = question;
        this.expectedAnswer = expectedAnswer;
        this.actualAnswer = actualAnswer;
    }

    @Override
    public int getAnswerID()
    {
        return this.answerID;
    }

    @Override
    public String getResultID()
    {
        return this.resultID;
    }

    @Override
    public String getQuestion()
    {
        return this.question;
    }

    @Override
    public String getExpectedAnswer()
    {
        return this.expectedAnswer;
    }

    @Override
    public String getActualAnswer()
    {
        return this.actualAnswer;
    }

}
