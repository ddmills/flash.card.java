package flash.card.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import flash.card.java.interfaces.QuizInterface;

public class Quiz implements QuizInterface{

    private int quizID;
    private Deck deck;
    private String title;
    private String description;
    private HashMap<String, Result> resultList;
    private User owner;

    public Quiz(int quizID, String title, String description, Deck d) {
        this.quizID = quizID;
        this.title = title;
        this.description = description;
        this.deck = d;
        this.resultList = new HashMap<String, Result>();
    }

    public Quiz(int quizID, String title, String description, User owner, Deck d) {
        this.quizID = quizID;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.deck = d;
        this.resultList = new HashMap<String, Result>();
    }

    public Quiz(int quizID, String title, String description, User owner, Deck d, HashMap<String, Result> resultList) {
        this.quizID = quizID;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.deck = d;
        this.resultList = resultList;
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

    @Override
    public Deck getDeck() {
        return deck;
    }

    @Override
    public User getOwner() {
        return owner;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public HashMap<String, Result> getResults() {
        return resultList;
    }

    @Override
    public boolean addResult(Result result)
    {
        this.resultList.put(result.getStudent().getUserID(), result);
        return true;
    }

    @Override
    public boolean setQuizTitle(String quizTitle)
    {
        this.title = quizTitle;
        return true;
    }
    
    @Override
    public Result retrieveResults(String studentID)
    {
        return resultList.get(studentID);
    }
    
    @Override
    public List<Result> retrieveAllResults()
    {
        return new ArrayList<Result>(resultList.values());
    }
}
