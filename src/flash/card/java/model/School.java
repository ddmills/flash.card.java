package flash.card.java.model;

import java.util.HashMap;
import java.util.List;

import flash.card.java.db.DatabaseSupport;
import flash.card.java.interfaces.SchoolInterface;

public class School implements SchoolInterface {

    CurrentUser user;
    CurrentQuiz currentQuiz;
    DatabaseSupport db = null;

    public School() {
        this.user = new CurrentUser();
        this.currentQuiz = new CurrentQuiz();
        this.db = DatabaseSupport.getInstance();
    }


    @Override
    public boolean createTeacher(String name, String userID, String pass) {
        if (user.isSet()) {
            if (user.get().access() == AccessLevel.principal) {
                if(db.getUser(userID) == null) {
                    Teacher t = new Teacher(userID, pass, name);
                    return db.putTeacher(t);
                }
            }
        }
        return false;
    }

    @Override
    public boolean createStudent(String name, String userID, String pass) {
        Student s = new Student(name, userID, pass);

        return this.db.putStudent(s);
    }

    @Override
    public boolean login(String userID, String pass) {
        if (!user.isSet()) {
            try {
                User provided;
                provided = db.getUser(userID);
                if (provided.comparePassword(pass)) {
                    user.set(provided);
                    return true;
                }
            } catch(Exception e) {}
        }
        return false;
    }

    @Override
    public boolean logout() {
        return user.unset();
    }

    @Override
    public boolean createDeck(int deckID, String title, String description) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = new Deck(deckID, title, description);
                d.setOwner(this.user.get());
                return db.putDeck(d);
            }
        }
        return false;

    }

    @Override
    public boolean createCard(int cardID, String front, String back, int deckID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                d.createCard(cardID, front, back);
                return db.putDeck(d);
            }
        }
        return false;

    }

    @Override
    public boolean deleteCard(int cardID, int deckID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                Card c = d.getCard(cardID);
                d.deleteCard(c);
                return db.putDeck(d);
            }
        }
        return false;
    }

    @Override
    public boolean createQuiz(int quizID, String title, String description, int deckID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                Quiz q = new Quiz(quizID, title, description, this.user.get(), d);
                return db.putQuiz(q);
            }
        }
        return false;

    }

    @Override
    public boolean addQuizToStudent(String userID, int quizID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Student s = db.getStudent(userID);
                Quiz q = db.getQuiz(quizID);
                s.addQuiz(q);
                return this.db.putStudent(s);
            }
        }
        return false;
    }

    @Override
    public boolean removeQuizFromStudent(String userID, int quizID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Student s = db.getStudent(userID);
                Quiz q = db.getQuiz(quizID);
                s.removeQuiz(q);
                return this.db.putStudent(s);
            }
        }
        return false;
    }

    @Override
    public boolean createCourse(int courseID, String title) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Course c = new Course(courseID, (Teacher)user.get(), title, new HashMap<String, Student>());
                return this.db.putCourse(c);
            }
        }
        return false;
    }

    @Override
    public boolean editCourseName(int courseID, String courseName)
    {
        Course c = db.getCourse(courseID);

        if(c == null)
        {
            return false;
        }
        else
        {
            c.setCourseName(courseName);
            return db.putCourse(c);
        }
    }

    @Override
    public boolean editQuizTitle(int quizID, String quizTitle)
    {
        boolean b = true;
        Quiz q = db.getQuiz(quizID);
        
        if(q == null) return false;

        b = q.setQuizTitle(quizTitle);
        b = db.putQuiz(q);
        return b;

    }

    @Override
    public boolean addStudentToCourse(int courseID, String studentID)
    {
        Course c = db.getCourse(courseID);
        Student s = db.getStudent(studentID);
        return c.addStudentToCourse(s) ? db.putCourse(c) : false;
    }

    @Override
    public boolean removeStudentFromCourse(int courseID, String studentID)
    {
        Course c = db.getCourse(courseID);
        Student s = db.getStudent(studentID);
        return c.removeStudentFromCourse(s) ? db.putCourse(c) : false;
    }

    @Override
    public boolean deleteStudent(String studentID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Student s = db.getStudent(studentID);
                return db.deleteStudent(s);
            }
        }
        return false;
    }

    @Override
    public boolean deleteCourse(int courseID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Course c = db.getCourse(courseID);
                return db.deleteCourse(c);
            }
        }
        return false;
    }

    @Override
    public boolean deleteTeacher(String teacherID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.principal) {
                Teacher t = db.getTeacher(teacherID);
                return db.deleteTeacher(t);
            }
        }
        return false;
    }

    @Override
    public boolean deleteDeck(int deckID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                if (d.userOwnsDeck(user.get())) {
                    return db.deleteDeck(d);
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteQuiz(int quizID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Quiz q = db.getQuiz(quizID);
                if (q.userOwnsQuiz(user.get())) {
                    return db.deleteQuiz(q);
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean startQuiz(int quizID)
    {
        if (user.isSet())
        {
            if (user.get().access() == AccessLevel.student)
            {
                Quiz q = db.getQuiz(quizID);
                if(q != null)
                {
                    Student s = db.getStudent(user.getUserID());
                    if(s.checkListOfQuizzes(q))
                    {
                        currentQuiz.set(q);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean answerQuestion(int cardID, String answer)
    {
        return false;
    }
    
    @Override
    public List<String> retrieveResults(int quizID)
    {
        return null;
    }
    
    @Override
    public List<String> retrieveAllResults(int quizID)
    {
        return null;
    }
}
