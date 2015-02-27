package flash.card.java.model;

import java.util.HashMap;

import flash.card.java.interfaces.CourseInterface;

public class Course implements CourseInterface {

	private HashMap<String, Student> studentList;
	private String courseName;
	
	public Course (String courseName) {
		this.studentList = new HashMap<String, Student>();
		this.courseName = courseName;
	}
	
	public Course (String courseName, HashMap<String, Student> studentList) {
		this.studentList = studentList;
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
}
