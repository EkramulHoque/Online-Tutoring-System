package org.tutor.struts2.pagehandlers;
import org.apache.struts2.interceptor.SessionAware;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Student;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.model.*;
import org.tutor.struts2.ormhelper.SessionBean;
 


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class ProfileHandler extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String firstname, lastname, password, role, bio, photoPath;
	static String mediaLocation="../../assets/frontend/layout/img/media/";
	private static String f,l,b,p;
	
	private List<Course> courses;
	private List<Course> otherCourses;
	private Student student;
	private Instructor instructor;
	
	static SessionBean s= new SessionBean();
	
	
	public Student getStudent() {
		return student;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
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

	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	
  
	public String executeStudent(){
		
		Users e=(Users)ActionContext.getContext().getSession().get("user");
		
		 
    	if(e==null){  		
    		return ERROR;
    	}
  
    	 f=e.getFirstname();
    	 l=e.getLastname();
    	 b=e.getBio();
    	 p=e.getPassword();
    	
    	firstname=e.getFirstname();
    	lastname=e.getLastname();
    	bio=e.getBio();
    	email=e.getEmail();
    	
    	 
    	student = s.getStudent(email);
		courses = s.findByStudent(email);
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
		otherCourses = s.findOtherCoursesByStudent(email);
		
		System.out.println(student.getFirstname()+" "+student.getLastname() );
    	
    	password=e.getPassword();
    	photoPath=mediaLocation+e.getPhotoPath();
    	 
		return SUCCESS;
    	
	}
	
public String executeInstructor(){
		
		Users e=(Users)ActionContext.getContext().getSession().get("user");
    	if(e==null){  		
    		return ERROR;
    	}
  
    	 f=e.getFirstname();
    	 l=e.getLastname();
    	 b=e.getBio();
    	 p=e.getPassword();
    	
    	firstname=e.getFirstname();
    	lastname=e.getLastname();
    	bio=e.getBio();
    	email=e.getEmail();
    	
    	 
    	instructor= s.getInstructor(email);
    	courses=s.findByInstructor(email);
    	
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

		System.out.println(instructor.getFirstname()+" "+instructor.getLastname() );
    	
    	password=e.getPassword();
    	photoPath=mediaLocation+e.getPhotoPath();
    	 
		return SUCCESS;
    	
	}
	
	public String update(){
		
		Users e=(Users)ActionContext.getContext().getSession().get("user");
    	if(e==null){  		
    		return ERROR;
    	}
    	
    	
    	
    	
    	if(firstname==null || firstname.equals(" ") || firstname.isEmpty()){
    		
    		e.setFirstname(f);}
    	else{
    		
    		e.setFirstname(firstname);
    		
    	}
    	
    	
    	
    	if(lastname==null || lastname.equals(" ") || lastname.isEmpty()){
    	
    		e.setLastname(l);}
    	else{
    		
    		e.setLastname(lastname);
    		
    	}
    	
    	if(bio==null || bio.equals(" ") || bio.isEmpty()){
    		
    		e.setBio(b);}
    	else{
    		
    		e.setBio(bio);
    		
    	}
    	
    	if(password==null || password.equals(" ") || password.isEmpty()){
    		
    		e.setPassword(p);}
    	else{
    		
    		e.setPassword(password);
    		
    	}
    	
    	e.setEmail(e.getEmail());
    	
    	System.out.println(firstname);
    	 s.updateUser(e); 

    	 String role=e.getRole();
    	 if(role.equals("instructor"))
    		 return "instructor";
    	 else
    		 return "student";
    	 
		
	}
}
