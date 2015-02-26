package flash.card.java.model;

import flash.card.java.interfaces.StudentInterface;

public class Student extends User implements StudentInterface {

    String name;
    
    public Student(String name, String userID, String pass) {
        this.name = name;
        this.userID = userID;
        this.password = pass;
        this.accessLevel = AccessLevel.student;
    }

    @Override
    public int getUserID() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean addQuiz(Quiz q) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeQuiz(Quiz q) {
        // TODO Auto-generated method stub
        return false;
    }

}
