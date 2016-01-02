package org.tutor.struts2.pagehandlers;

import java.util.ArrayList;
import java.util.List;

import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Lecture;
import org.tutor.struts2.model.Student;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.ormhelper.SessionBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentCourseHandler extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email="";
	private Student student;
	
	private String courseID;
	private Course course;
	
	private List<Lecture> lectures;
	
	public StudentCourseHandler(){}
	
	public String execute() throws Exception{
		SessionBean s = new SessionBean();
		Users e=(Users)ActionContext.getContext().getSession().get("user");
    	if(e==null){  		
    		return ERROR;
    	}
    	this.email=e.getEmail();
		student = s.getStudent(email);
		System.out.println(courseID);
		course = s.getCourse(courseID);
		

		lectures = s.findByCourse(courseID);
		//System.out.println(courses.size());
		
		return SUCCESS;
		}
	
	public String getID() throws Exception{

		return SUCCESS;
		}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
