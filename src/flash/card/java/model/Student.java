package flash.card.java.model;

import java.util.HashMap;

import flash.card.java.interfaces.StudentInterface;

public class Student extends User implements StudentInterface {

    private HashMap<Integer, Quiz> quizList;

    public Student(String userID, String pass, String name) {
        super(userID, pass, name);
        this.accessLevel = AccessLevel.student;
        this.quizList = new HashMap<Integer, Quiz>();
    }

    @Override
    public String getUserID() {
        
        return this.userID;
    }

    @Override
    public boolean addQuiz(Quiz q) {
        this.quizList.put(q.getQuizID(), q);
        return true;
    }

    @Override
    public boolean removeQuiz(Quiz q) {
        return this.quizList.remove(q.getQuizID(), q);
    }
}
