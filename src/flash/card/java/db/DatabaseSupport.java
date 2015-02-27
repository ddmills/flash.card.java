package flash.card.java.db;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import flash.card.java.interfaces.DatabaseSupportInterface;
import flash.card.java.model.Card;
import flash.card.java.model.Deck;
import flash.card.java.model.Principal;
import flash.card.java.model.Quiz;
import flash.card.java.model.Student;
import flash.card.java.model.Teacher;
import flash.card.java.model.User;

public class DatabaseSupport implements DatabaseSupportInterface {
    private static DatabaseSupport instance = null;
    private Connection connection = null;
    
    private DatabaseSupport() {
        connection = getConnection();
    }
    
    public static DatabaseSupport getInstance() {
        if (instance == null) {
            instance = new DatabaseSupport();
        }
        return instance;
    }

    @Override
    public User getUser(String userID) {
        if (userID.equals("admin")) {
            return new Principal("admin", "admin", "admin");
        }
        return null;
    }

    @Override
    public Student getStudent(String studentID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean putStudent(Student s) {
        return true;
    }
    
    @Override
    public boolean putPrincipal(Principal p) {
        return false;
    }
    
    @Override
    public boolean putTeacher(Teacher t) {
        
        try {
            Statement stmt = connection.createStatement();
            //stmt.executeUpdate(insert("User", t.getUserID(), t.getName(), t.getPassword()))
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return true;
    }

    @Override
    public Deck getDeck(int deckID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean putDeck(Deck d) {
        // TODO Auto-generated method stub
        return false;

    }

    @Override
    public Card putCard(Card c) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeCard(Deck d, Card c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Quiz getQuiz(String quizID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean putQuiz(Quiz q) {
        // TODO Auto-generated method stub
        return false;
    }
    
    private Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/flashcards", "root", "root");
        } catch (Exception e) {
            connection = null;
            e.printStackTrace();
        }
        return connection;
    }
    

}
