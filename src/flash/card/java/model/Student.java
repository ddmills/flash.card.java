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
    
    public Student(String userID, String pass, String name, HashMap<Integer, Quiz> quizList) {
        super(userID, pass, name);
        this.quizList = quizList;
        this.accessLevel = AccessLevel.student;
    }

    @Override
    public String getUserID() {
        return userID;
    }

    @Override
    public boolean addQuiz(Quiz q) {
    
        if(!quizList.containsKey(q.getQuizID())) {
            quizList.put(q.getQuizID(), q);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeQuiz(Quiz q) {

        if(quizList.containsKey(q.getQuizID())) {
            quizList.remove(q.getQuizID());
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public HashMap<Integer, Quiz> getQuizzes() {
        return quizList;
    }
    
    @Override
    public boolean checkListOfQuizzes(Quiz q) {
        return quizList.containsKey(q.getQuizID());
    }
}
