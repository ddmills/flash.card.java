package flash.card.java.interfaces;

import java.util.HashMap;

import flash.card.java.model.Student;

public interface CourseInterface {
	public String getCourseName();
	public int getCourseID();
	public HashMap<String, Student> getStudentList();
	public boolean addStudentToCourse(Student s);
}
