package flash.card.java.db;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;

import flash.card.java.interfaces.DatabaseSupportInterface;
import flash.card.java.model.Answer;
import flash.card.java.model.Card;
import flash.card.java.model.Course;
import flash.card.java.model.Deck;
import flash.card.java.model.Principal;
import flash.card.java.model.Quiz;
import flash.card.java.model.Result;
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
    private String[] courseColumns = {"courseID", "title", "ownerID"};
    private String[] resultColumns = {"resultID", "quizID", "userID", "score"};
    private String[] answerColumns = {"answerID", "resultID", "question", "expectedanswer", "actualanswer"};
    private String[] courseRelationsColumns = {"courseID", "userID"};
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
            }
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
            String sql = DatabaseHelpers.select("quiz_relation", quizRelationsColumns[1], studentID);
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
        try {
            Statement stmt = connection.createStatement();
            String sql;
            User check = this.getUser(s.getUserID());
            if(check == null) {
                sql = DatabaseHelpers.insert("user", userColumns, s.getUserID(), "student", s.getName(), s.getPassword());
            } else {
                sql = DatabaseHelpers.update("user", userColumns[0], s.getUserID(), userColumns, s.getUserID(), "student", s.getName(), s.getPassword());
            }
            stmt.executeUpdate(sql);

            Statement stmtClean = connection.createStatement();
            sql = "delete from quiz_relation where studentID = \"" + s.getUserID() + "\";";
            stmtClean.execute(sql);
            HashMap<Integer, Quiz> quizzes = s.getQuizzes();
            for (Integer quizID : quizzes.keySet()) {
                Statement stmtInsert = connection.createStatement();
                sql = DatabaseHelpers.insert("quiz_relation", quizRelationsColumns, quizID.toString(), s.getUserID());
                stmtInsert.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean putPrincipal(Principal p) {
        try {
            Statement stmt = connection.createStatement();
            String sql;
            User check = this.getUser(p.getUserID());
            if(check == null) {
                sql = DatabaseHelpers.insert("user", userColumns, p.getUserID(), "principal", p.getName(), p.getPassword());
            } else {
                sql = DatabaseHelpers.update("user", userColumns[0], p.getUserID(), userColumns, p.getUserID(), "principal", p.getName(), p.getPassword());
            }
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
        try {
            Statement stmt = connection.createStatement();
            String sql = DatabaseHelpers.select("deck", deckColumns[0], "" + deckID);
            ResultSet results = stmt.executeQuery(sql);
            if (results.next()) {
                User u = getUser(results.getString(2));
                Deck d = new Deck(results.getInt(1), results.getString(3), results.getString(4), u);
                Statement cardstmt = connection.createStatement();
                String cardsql = "select * from card where deckID = \"" + d.getDeckID() + "\";";
                ResultSet cards = cardstmt.executeQuery(cardsql);
                while (cards.next()) {
                    d.createCard(cards.getInt(1), cards.getString(3), cards.getString(4));
                }
                return d;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean putDeck(Deck d) {
        try {
            Statement stmt = connection.createStatement();
            String sql;
            Deck check = this.getDeck(d.getDeckID());
            if(check == null) {
                sql = DatabaseHelpers.insert("deck", deckColumns, "" + d.getDeckID(), d.getOwnerID(), d.getTitle(), d.getDescription());
            } else {
                sql = DatabaseHelpers.update("deck", deckColumns[0], "" + d.getDeckID(), deckColumns, "" + d.getDeckID(), d.getOwnerID(), d.getTitle(), d.getDescription());
            }
            stmt.executeUpdate(sql);

            Statement stmtClean = connection.createStatement();
            sql = "delete from card where deckID = \"" + d.getDeckID() + "\";";
            stmtClean.execute(sql);
            HashMap<Integer, Card> cards = d.getCards();
            for (Integer cardID : cards.keySet()) {
                Card c = cards.get(cardID);
                Statement stmtInsert = connection.createStatement();
                sql = DatabaseHelpers.insert("card", cardColumns, "" + c.getCardID(), "" + d.getDeckID(), c.getFront(), c.getBack());
                stmtInsert.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Quiz getQuiz(int quizID) {
        try {
            Statement stmt = connection.createStatement();
            String sql = DatabaseHelpers.select("quiz", quizColumns[0], "" + quizID);
            ResultSet results = stmt.executeQuery(sql);
            if (results.next()) {
                Deck d = this.getDeck(results.getInt(2));
                User u = this.getUser(results.getString(3));
                Quiz q = new Quiz(results.getInt(1), results.getString(4), results.getString(5), u, d);
                
                Statement resultstmt = connection.createStatement();
                String resultsql = "select * from result where quizID = \"" + q.getQuizID() + "\";";
                ResultSet quizResults = resultstmt.executeQuery(resultsql);
                while (quizResults.next()) {
                    Student s = (Student)this.getUser(quizResults.getString(3));
                    Result r = new Result(q.getQuizID(), s, quizResults.getInt(4));
                    
                    Statement answerstmt = connection.createStatement();
                    String answersql = "select * from answer where resultID = \"" + r.getResultID() + "\";";
                    ResultSet answerResults = answerstmt.executeQuery(answersql);
                    while (answerResults.next()) {
                        Answer answer = new Answer(answerResults.getInt(1), answerResults.getString(3), answerResults.getString(4), answerResults.getString(5));
                        r.addAnswer(answer);
                    }
                    
                    q.addResult(r);
                }
                return q;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean putQuiz(Quiz q) {
        try {
            Statement stmt = connection.createStatement();
            String sql;
            Quiz check = this.getQuiz(q.getQuizID());
            if(check == null) {
                sql = DatabaseHelpers.insert("quiz", quizColumns, "" + q.getQuizID(), "" + q.getDeck().getDeckID(), q.getOwner().getUserID(), q.getTitle(), q.getDescription());
            } else {
                sql = DatabaseHelpers.update("quiz", quizColumns[0], "" + q.getQuizID(), quizColumns, "" + q.getQuizID(), "" + q.getDeck().getDeckID(), q.getOwner().getUserID(), q.getTitle(), q.getDescription());
            }
            stmt.executeUpdate(sql);
            
            Statement stmtClean = connection.createStatement();
            sql = "delete from result where quizID = \"" + q.getQuizID() + "\";";
            stmtClean.execute(sql);
            HashMap<String, Result> results = q.getResults();
            for (String studentID : results.keySet()) {
                Result r = results.get(studentID);
                Statement stmtInsert = connection.createStatement();
                sql = DatabaseHelpers.insert("result", resultColumns, r.getResultID(), "" + q.getQuizID(), "" + r.getStudent().getUserID(), "" + r.getScore());
                stmtInsert.execute(sql);
                
                Statement stmtCleanA = connection.createStatement();
                sql = "delete from answer where resultID = \"" + r.getResultID() + "\";";
                stmtCleanA.execute(sql);
                HashMap<Integer, Answer> answers = r.getAnswers();
                for (Integer answerID : answers.keySet()) {
                    Answer a = answers.get(answerID);
                    Statement stmtInsertA = connection.createStatement();
                    sql = DatabaseHelpers.insert("answer", answerColumns, "" + a.getAnswerID(), r.getResultID(), a.getQuestion(), a.getExpectedAnswer(), a.getActualAnswer());
                    stmtInsertA.execute(sql);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
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

    @Override
    public boolean putCourse(Course c) {
        try {
            Statement stmt = connection.createStatement();
            String sql;
            Course check = this.getCourse(c.getCourseID());
            if(check == null) {
                sql = DatabaseHelpers.insert("course", courseColumns, "" + c.getCourseID(), c.getCourseName(), c.getOwner().getUserID());
            } else {
                sql = DatabaseHelpers.update("course", courseColumns[0], "" + c.getCourseID(), courseColumns, "" + c.getCourseID(), c.getCourseName(), c.getOwner().getUserID() );
            }
            stmt.executeUpdate(sql);
            
            Statement stmtClean = connection.createStatement();
            sql = "delete from course_relation where courseID = \"" + c.getCourseID() + "\";";
            stmtClean.execute(sql);
            
            HashMap<String, Student> studentList = c.getStudentList();
            for(String sKey : studentList.keySet())
            {
                Student s = studentList.get(sKey);
                Statement insertStatement = connection.createStatement();
                sql = DatabaseHelpers.insert("course_relation", courseRelationsColumns, "" + c.getCourseID(), s.getUserID());
                insertStatement.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Course getCourse(int courseID)
    {
        try
        {
            Statement stmt = connection.createStatement();
            String sql = DatabaseHelpers.select("course", courseColumns[0], "" + courseID);
            ResultSet results = stmt.executeQuery(sql);
            Course c = null;
            if(results.next()) {
                c = new Course(results.getInt(1), this.getTeacher(results.getString(3)), results.getString(2), new HashMap<String, Student>());
                
                Statement studentStmt = connection.createStatement();
                String studentSql = "select * from course_relation where courseID = \"" + c.getCourseID() + "\";";
                ResultSet students = studentStmt.executeQuery(studentSql);
                while(students.next())
                {
                    Student s = this.getStudent(students.getString(3));
                    c.addStudentToCourse(s);
                }
                
                return c;
            }
            
        }
        catch (SQLException e)
        {
                e.printStackTrace();
        }
        return null;
    }

    @Override
    public Teacher getTeacher(String teacherID)
    {
        return (Teacher) getUser(teacherID);
    }

    @Override
    public boolean deleteDeck(int deckID)
    {
        try {
            Statement stmt = connection.createStatement();
            String sql = DatabaseHelpers.delete("Deck", deckColumns[0], "" + deckID);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteQuiz(int quizID)
    {
        try {
            Statement stmt = connection.createStatement();
            String sql = DatabaseHelpers.delete("Quiz", quizColumns[0], "" + quizID);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCourse(int courseID)
    {
        try {
            Statement stmt = connection.createStatement();
            String sql = DatabaseHelpers.delete("course", courseColumns[0], "" + courseID);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String studentID)
    {
        try {
            Statement stmt = connection.createStatement();
            String sql = DatabaseHelpers.delete("user", userColumns[0], studentID);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTeacher(String teacherID)
    {
        try {
            Statement stmt = connection.createStatement();
            String sql = DatabaseHelpers.delete("user", userColumns[0], teacherID);
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
