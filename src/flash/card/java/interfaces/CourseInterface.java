package flash.card.java.interfaces;

import java.util.HashMap;

import flash.card.java.model.Student;
import flash.card.java.model.Teacher;

public interface CourseInterface {
    public String getCourseName();
    public int getCourseID();
    public HashMap<String, Student> getStudentList();
    public boolean addStudentToCourse(Student s);
    public boolean setOwner(Teacher owner);
    public Teacher getOwner();
}
