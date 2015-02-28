package flash.card.java.db;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    
    private String[] userColumns = {"username", "type", "name", "password"};
    private String[] cardColumns = {"cardID", "deckID", "front", "back"};
    private String[] quizColumns = {"quizID", "deckID", "ownerID", "title", "description"};
    private String[] deckColumns = {"deckID", "ownerID", "title", "description"};
    private String[] quizRelationsColumns = {"quizID", "studentID"};
    
    
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
    	try {
    		Statement stmt = connection.createStatement();
            String sql = DatabaseHelpers.select("user", userColumns[0], userID);
            ResultSet results = stmt.executeQuery(sql);
            if(results.next()) {
	            switch(results.getString(2)) {
	            case "teacher":
	            	return new Teacher(results.getString(1), results.getString(4), results.getString(3));
	            case "student":
	            	return new Student(results.getString(1), results.getString(4), results.getString(3));
	            case "principal":
	            	return new Principal(results.getString(1), results.getString(4), results.getString(3));
	            }
            } else {
            	results.close();
            	return null;
            	
            }
            
            results.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
        return null;
    }

    @Override
    public Student getStudent(String studentID) {
    	
    	Student student = (Student) getUser(studentID);
    	try {
    		Statement stmt = connection.createStatement();
    		
    		String sql = "select quizID from quiz_relation where studentID = \"" + student.getUserID() + "\";";
    		
    		ResultSet quizIDs = stmt.executeQuery(sql);
    		
    		while(quizIDs.next()) {
    			Quiz currentQuiz = this.getQuiz(quizIDs.getInt(2));
    			student.addQuiz(currentQuiz);
    		}
    		quizIDs.close();
    		
    		return student;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
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
        	String sql;
        	User check = this.getUser(t.getUserID());
        	if(check == null) {
        		sql = DatabaseHelpers.insert("user", userColumns, t.getUserID(), "teacher", t.getName(), t.getPassword());
        	} else {
        		sql = DatabaseHelpers.update("user", userColumns[0], t.getUserID(), userColumns, t.getUserID(), "teacher", t.getName(), t.getPassword());
        	}
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
    public Quiz getQuiz(int quizID) {
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
