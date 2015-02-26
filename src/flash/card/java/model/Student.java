package flash.card.java.model;

import flash.card.java.interfaces.StudentInterface;

public class Student implements StudentInterface {

    int userID;
    String name;
    String password;
    
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
