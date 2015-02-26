package flash.card.java.model;

import java.util.ArrayList;

import flash.card.java.interfaces.StudentInterface;

public class Student extends User implements StudentInterface {

    private ArrayList<Quiz> quizList;

    public Student(String userID, String pass, String name) {
        super(userID, pass, name);
        this.accessLevel = AccessLevel.student;
        this.quizList = new ArrayList<Quiz>();
    }

    @Override
    public String getUserID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addQuiz(Quiz q) {
        return this.quizList.add(q);
    }

    @Override
    public boolean removeQuiz(Quiz q) {
        return this.quizList.remove(q);
    }

}
