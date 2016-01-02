package org.tutor.struts2.pagehandlers;

import java.util.ArrayList;
import java.util.List;

import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Question;
import org.tutor.struts2.model.Student;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.ormhelper.SessionBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EnrolledCoursesHandler extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email="";
	private Student student;
	private List<Course> courses;
	
	public EnrolledCoursesHandler(){}
	
	public String execute() throws Exception{
		SessionBean s = new SessionBean();
		Users e=(Users)ActionContext.getContext().getSession().get("user");
    	if(e==null){  		
    		return ERROR;
    	}
    	
		student = s.getStudent(e.getEmail());
		courses = s.findByStudent(e.getEmail());
		
		List<Course> allQ = new ArrayList<Course>();
		int j=0;
		for (int i=0; i<courses.size(); i++){					
			j=0;
			for (j=0; j<allQ.size(); j++){
				if(courses.get(i).getCourseID().equals( allQ.get(j).getCourseID() )){
					break;
				}
			}
			
			if(j==allQ.size()){
				allQ.add(courses.get(i));
			}					
		}
		courses=allQ;
		return SUCCESS;
		}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	

}
