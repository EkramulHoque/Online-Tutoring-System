package org.tutor.struts2.pagehandlers;

import java.util.List;

import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Instructor;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.ormhelper.SessionBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OpenNewCourseHandler extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email="";
	private Instructor instructor;
	
	private List<Course> courses;

	private Course newCourse;
	private String newCourseID, newCourseTitle, newCourseDescription;

	public OpenNewCourseHandler() {
		System.out.println(newCourseID);
		System.out.println(newCourseTitle);
		System.out.println(newCourseDescription);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course getNewCourse() {
		return newCourse;
	}

	public void setNewCourse(Course newCourse) {
		this.newCourse = newCourse;
	}

	public String getNewCourseID() {
		return newCourseID;
	}

	public void setNewCourseID(String newCourseID) {
		this.newCourseID = newCourseID;
	}

	public String getNewCourseTitle() {
		return newCourseTitle;
	}

	public void setNewCourseTitle(String newCourseTitle) {
		this.newCourseTitle = newCourseTitle;
	}

	public String getNewCourseDescription() {
		return newCourseDescription;
	}

	public void setNewCourseDescription(String newCourseDescription) {
		this.newCourseDescription = newCourseDescription;
	}
	
	public String execute() throws Exception{
		SessionBean s = new SessionBean();
		Users e=(Users)ActionContext.getContext().getSession().get("user");
    	if(e==null){  		
    		return ERROR;
    	}
    	this.email=e.getEmail();
		instructor = s.getInstructor(email);
		courses = s.findByInstructor(email);
		
		newCourse = new Course();
		newCourse.setCourseID(newCourseID);
		newCourse.setCourseTitle(newCourseTitle);
		newCourse.setCourseDescription(newCourseDescription);
		newCourse.setInstructor(instructor);
		
		courses.add(newCourse);
		s.saveCourse(newCourse);
		
		return SUCCESS;
		}
	

}
