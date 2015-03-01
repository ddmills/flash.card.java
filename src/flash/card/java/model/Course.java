package flash.card.java.model;

import java.util.HashMap;

import flash.card.java.interfaces.CourseInterface;

public class Course implements CourseInterface {

	private HashMap<String, Student> studentList;
	private String courseName;
	private int courseID;
	
	public Course (int courseID, String courseName) {
		this.studentList = new HashMap<String, Student>();
		this.courseName = courseName;
		this.courseID = courseID;
	}
	
	public Course (int courseID, String courseName, HashMap<String, Student> studentList) {
		this.courseID = courseID;
		this.studentList = studentList;
		this.courseName = courseName;
	}
	
	public int getCourseID() {
		return this.courseID;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public HashMap<String, Student> getStudentList() {
		return studentList;
	}
	
	public boolean addStudentToCourse(Student s) {
		if(!studentList.containsKey(s.getUserID())) {
			studentList.put(s.getUserID(), s);
			return true;
		} else {
			return false;
		}
	}
}
