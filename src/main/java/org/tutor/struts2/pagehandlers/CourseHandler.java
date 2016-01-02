package org.tutor.struts2.pagehandlers;

import java.util.List;

import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Instructor;
import org.tutor.struts2.model.Lecture;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.ormhelper.SessionBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CourseHandler extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email="";
	private Instructor instructor;
	
	private String courseID;
	private Course course;
	
	 
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

	private List<Course> courses;
	private List<Course> otherCourses;
	Lecture l1=new Lecture();	
	private List<Lecture> lectures;
	
	public CourseHandler(){}
	
	public String execute() throws Exception{
		
		Instructor e = (Instructor)ActionContext.getContext().getSession().get("user");
		System.out.println(e.getFirstname());

		System.out.println(courseID);
		SessionBean s = new SessionBean();
		List<Course> instList = s.findByInstructor(e.getEmail());
		boolean z = false;
		for (Course cr : instList){
			if (cr.getCourseID().equals(courseID)){
				z=true;
			}
		}
		if (z==false)
			return ERROR;
		    	
    	String email=e.getEmail();
     		
 	    	instructor= s.getInstructor(email);
 	    	courses=s.findByInstructor(email);
 			System.out.println(instructor.getFirstname()+" "+instructor.getLastname() );
    	
    	this.email=e.getEmail();
		instructor = s.getInstructor(email);
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

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
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
	
	

}
