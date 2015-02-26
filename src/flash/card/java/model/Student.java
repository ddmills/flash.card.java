package flash.card.java.model;

import java.util.ArrayList;

import flash.card.java.interfaces.StudentInterface;

public class Student extends User implements StudentInterface {

    String name;
    ArrayList<Quiz> quizList;
    
    public Student(String name, String userID, String pass) {
        this.name = name;
        this.userID = userID;
        this.password = pass;
        this.accessLevel = AccessLevel.student;
        this.quizList = new ArrayList<Quiz>();
    }

    @Override
    public int getUserID() {
        // TODO Auto-generated method stub
        return 0;
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
