package org.tutor.struts2.pagehandlers;

import java.util.ArrayList;
import java.util.List;

import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Student;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.ormhelper.SessionBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindCoursesHandler extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String email="";
	private static Student student;
	private List<Course> courses;
	private List<Course> allCourses;
	private List<Course> otherCourses;
	private String newEnrolledCourseID;
	private Course newEnrolledCourse;

	public FindCoursesHandler(){}
	
	public String execute() throws Exception{
		SessionBean s = new SessionBean();
		Users e=(Users)ActionContext.getContext().getSession().get("user");
    	if(e==null){  		
    		return ERROR;
    	}
    	this.email=e.getEmail();
		student = s.getStudent(email);
		courses = s.findByStudent(email);
		allCourses = s.findOtherCoursesByStudent(email);
		otherCourses= new ArrayList<Course>();
		
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
		
		
		 
		for (int i=0; i<allCourses.size(); i++){
			j=0;
			for (j=0; j<courses.size(); j++){
				if(allCourses.get(i).getCourseID().equals(courses.get(j).getCourseID())){
					break;
				}
			}
			
			if(j==courses.size()){
				otherCourses.add(allCourses.get(i));
			}
		}
		
	
		
		return SUCCESS;
		}
	
	public String enroll() throws Exception{
		SessionBean s = new SessionBean();
		student = s.getStudent(email);
		courses = s.findByStudent(email);
		
		newEnrolledCourse = s.getCourse(newEnrolledCourseID);

		for(int i=0;i<courses.size();i++){
			if(courses.get(i).getCourseID().equals(newEnrolledCourse)){
				return SUCCESS;
			}
		}
		//courses.add(newEnrolledCourse);
		student.getEnrolledCourses().add(newEnrolledCourse);
		s.updateStudent(student);
		
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

	public List<Course> getOtherCourses() {
		return otherCourses;
	}

	public void setOtherCourses(List<Course> otherCourses) {
		this.otherCourses = otherCourses;
	}

	public String getNewEnrolledCourseID() {
		return newEnrolledCourseID;
	}

	public void setNewEnrolledCourseID(String newEnrolledCourseID) {
		this.newEnrolledCourseID = newEnrolledCourseID;
	}

	public Course getNewEnrolledCourse() {
		return newEnrolledCourse;
	}

	public void setNewEnrolledCourse(Course newEnrolledCourse) {
		this.newEnrolledCourse = newEnrolledCourse;
	}

	public List<Course> getAllCourses() {
		return allCourses;
	}

	public void setAllCourses(List<Course> allCourses) {
		this.allCourses = allCourses;
	}
	
	

}