package org.tutor.struts2.pagehandlers;

import org.tutor.struts2.model.Instructor;
import org.tutor.struts2.model.Question;
import org.tutor.struts2.model.Quiz;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.ormhelper.SessionBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.tutor.struts2.model.Course;

import java.io.InputStream;
import java.util.List;




public class InstructedCoursesHandler extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email="";
	private Instructor instructor;
	
	private List<Course> courses;
	private InputStream inputStream;
	
	public InstructedCoursesHandler() {		
	}
	
	public String execute() throws Exception{
		Users e=(Users)ActionContext.getContext().getSession().get("user");
    	if(e==null){  		
    		return ERROR;
    	}
    	this.email=e.getEmail();
	SessionBean s = new SessionBean();
	instructor = s.getInstructor(email);
	courses = s.findByInstructor(email);
	
	//System.out.println(courses.size());
	
	return SUCCESS;
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
	

}
