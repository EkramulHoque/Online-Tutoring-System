package org.tutor.struts2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student extends Users {
	

	@ManyToMany (fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name="Student_Taking_Courses", joinColumns=@JoinColumn(name="Student_ID"),
			inverseJoinColumns=@JoinColumn(name="Course_ID"))
	private List<Course> enrolledCourses = new ArrayList<Course>();
	
	public Student(){
		super();
		super.setRole("student");
		super.setBio("");
	}
	
	public Student(String email, String password){
		super(email, password);
		super.setRole("student");
		super.setBio("blank");
		super.setPhotoPath("no-photo-male.png");
	}

	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(List<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	
	
	
	

}
