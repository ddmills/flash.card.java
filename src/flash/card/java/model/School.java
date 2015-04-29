package flash.card.java.model;

import java.util.HashMap;
import java.util.List;

import flash.card.java.db.DatabaseSupport;
import flash.card.java.interfaces.SchoolInterface;

public class School implements SchoolInterface {

    CurrentUser user;
    DatabaseSupport db = null;

    public School() {
        this.user = CurrentUser.getInstance();
        this.db = DatabaseSupport.getInstance();
    }


    @Override
    public boolean createTeacher(String userID, String pass, String name) {
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
    public boolean createStudent(String userID, String pass, String name) {
        if (user.isSet()) {
            if (user.get().access() == AccessLevel.teacher) {
                if (db.getUser(userID) == null)) {
                    Student s = new Student(userID, pass, name);
                    return this.db.putStudent(s);
                }
            }
        }
        return false;
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
        if (user.isSet()) {
            if (user.get().accessLevel == AccessLevel.teacher) {
                if (db.getDeck(deckID) == null) {
                    Deck d = new Deck(deckID, title, description);
                    d.setOwner(this.user.get());
                    return db.putDeck(d);
                }
            }
        }
        return false;
    }

    @Override
    public boolean createCard(int cardID, String front, String back, int deckID) {
        if (user.isSet()) {
            if (user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                if (d != null) {
                    if (d.getCard(cardID) == null) {
                        d.createCard(cardID, front, back);
                        return db.putDeck(d);
                    }
                }
            }
        }
        return false;

    }

    @Override
    public boolean deleteCard(int cardID, int deckID) {
        if (user.isSet()) {
            if (user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                if (d != null) {
                    boolean exists = d.deleteCard(cardID);
                    if (exists) return db.putDeck(d);
                }
            }
        }
        return false;
    }

    @Override
    public boolean createQuiz(int quizID, String title, String description, int deckID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                if(d != null)
                {
                    Quiz q = new Quiz(quizID, title, description, d);
                    q.setOwner(this.user.get());
                    return db.putQuiz(q);
                }
            }
        }
        return false;

    }

    @Override
    public boolean addQuizToStudent(String userID, int quizID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Student s = db.getStudent(userID);
                if(s != null)
                {
                    Quiz q = db.getQuiz(quizID);
                    if(q != null)
                    {
                        return s.addQuiz(q) ? db.putStudent(s) : false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeQuizFromStudent(String userID, int quizID) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Student s = db.getStudent(userID);
                if(s != null)
                {
                    Quiz q = db.getQuiz(quizID);
                    if(q != null)
                    {
                        return s.removeQuiz(q) ? db.putStudent(s) : false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean createCourse(int courseID, String title) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                if(db.getCourse(courseID) == null) {
                    Course c = new Course(courseID, (Teacher)user.get(), title, new HashMap<String, Student>());
                    return this.db.putCourse(c);
                }
            }
        }
        return false;
    }

    @Override
    public boolean editCourseName(int courseID, String courseName)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Course c = db.getCourse(courseID);
                if(c != null)
                {
                    c.setCourseName(courseName);
                    return db.putCourse(c);
                }
            }
        }
        return false;
    }

    @Override
    public boolean editDeckTitle(int deckID, String deckTitle)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                if(d != null)
                {
                    d.setDeckTitle(deckTitle);
                    return db.putDeck(d);
                }
            }
        }
        return false;
    }

    @Override
    public boolean editQuizTitle(int quizID, String quizTitle)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Quiz q = db.getQuiz(quizID);
                if(q != null)
                {
                    q.setQuizTitle(quizTitle);
                    return db.putQuiz(q);
                }
            }
        }
        return false;
    }

    @Override
    public boolean addStudentToCourse(int courseID, String studentID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Course c = db.getCourse(courseID);
                if(c != null)
                {
                    Student s = db.getStudent(studentID);
                    if(s != null)
                    {
                        return c.addStudentToCourse(s) ? db.putCourse(c) : false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeStudentFromCourse(int courseID, String studentID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Course c = db.getCourse(courseID);
                if(c != null)
                {
                    Student s = db.getStudent(studentID);
                    if(s != null)
                    {
                        return c.removeStudentFromCourse(s) ? db.putCourse(c) : false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String studentID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                return db.deleteStudent(studentID);
            }
        }
        return false;
    }

    @Override
    public boolean deleteCourse(int courseID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                return db.deleteCourse(courseID);
            }
        }
        return false;
    }

    @Override
    public boolean deleteTeacher(String teacherID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.principal) {
                return db.deleteTeacher(teacherID);
            }
        }
        return false;
    }

    @Override
    public boolean deleteDeck(int deckID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                return db.deleteDeck(deckID);
            }
        }
        return false;
    }

    @Override
    public boolean deleteQuiz(int quizID)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                return db.deleteQuiz(quizID);
            }
        }
        return false;
    }

    @Override
    public Quiz startQuiz(int quizID)
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
                        return q;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean endQuiz(int quizID, Result result)
    {
        if (user.isSet())
        {
            if (user.get().access() == AccessLevel.student)
            {
                Quiz q = db.getQuiz(quizID);
                if(q != null)
                {
                    q.addResult(result);
                    return db.putQuiz(q);
                }
            }
        }
        return false;
    }

    @Override
    public Result retrieveResults(int quizID)
    {
        if (user.isSet())
        {
            if (user.get().access() == AccessLevel.student)
            {
                String studentID = this.user.getUserID();
                Quiz q = db.getQuiz(quizID);
                if(q != null)
                {
                    return q.retrieveResults(studentID);
                }
            }
        }
        return null;
    }

    @Override
    public List<Result> retrieveAllResults(int quizID)
    {
        if (user.isSet())
        {
            if (user.get().access() == AccessLevel.teacher)
            {
                Quiz q = db.getQuiz(quizID);
                if(q != null)
                {
                    return q.retrieveAllResults();
                }
            }
        }
        return null;
    }

    @Override
    public boolean editCardFront(int deckID, int cardID, String front)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                if(d != null)
                {
                    boolean updated = d.setCardFront(cardID, front);
                    if(updated)
                    {
                        return db.putDeck(d);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean editCardBack(int deckID, int cardID, String back)
    {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Deck d = db.getDeck(deckID);
                if(d != null)
                {
                    boolean updated = d.setCardBack(cardID, back);
                    if(updated)
                    {
                        return db.putDeck(d);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean editStudentName(String studentID, String name) {
        if(user.isSet()) {
            if(user.get().accessLevel == AccessLevel.teacher) {
                Student s = db.getStudent(studentID);
            }
        }

        return false;
    }

    @Override
    public boolean editStudentPassword(String studentID, String password) {
        return false;
    }
}
