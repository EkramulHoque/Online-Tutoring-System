package org.tutor.struts2.pagehandlers;

import java.sql.Time;
import java.util.List;

import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Instructor;
import org.tutor.struts2.model.Lecture;
import org.tutor.struts2.model.Media;
import org.tutor.struts2.model.Quiz;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.ormhelper.SessionBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NewLectureHandler extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email="";
	private Instructor instructor;
	private List<Course> courses;
	private List<Course> otherCourses;
	Lecture l1=new Lecture();	
	static	int lectureID;
	
	public List<Course> getOtherCourses() {
		return otherCourses;
	}

	public void setOtherCourses(List<Course> otherCourses) {
		this.otherCourses = otherCourses;
	}

	public static int getLectureID() {
		return lectureID;
	}

	public static void setLectureID(int lectureID) {
		NewLectureHandler.lectureID = lectureID;
	}

	private static String courseID;
	private Course course;
	
	private List<Lecture> lectures;
	private Lecture newLecture;
	
	private String newLectureTitle, newLectureDescription;
	
	
	
	public NewLectureHandler(){}
	
	public String open() throws Exception{
		
		SessionBean session= new SessionBean();
		Users e=(Users)ActionContext.getContext().getSession().get("user");
		 
		
		if(e==null){  		
    		return ERROR;
    	}
    	
    	String email=e.getEmail();
		l1=session.getLecture(lectureID);
     		
 	    	instructor= session.getInstructor(email);
 	    	courses=session.findByInstructor(email);
 			System.out.println(instructor.getFirstname()+" "+instructor.getLastname() );
 
		System.out.println("open - "+courseID);
		return SUCCESS;
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

		System.out.println("execute - "+courseID);
		course= s.getCourse(courseID);
		lectures=s.getLecturesByCourse(courseID);
		
		newLecture = new Lecture();
		newLecture.setLectureTitle(newLectureTitle);
		newLecture.setLectureDescription(newLectureDescription);
		newLecture.setCourse(course);
		
		Media video = new Media();
		video.setMediaTitle("empty");
		video.setType("empty");
		video.setPath("empty");

		newLecture.getMaterials().add(video);
		
		Quiz test = new Quiz();
		test.setQuizName("Empty");
		test.setDuration(new Time(0,1,0));
		test.setLecture(newLecture);
		newLecture.setQuiz(test);
		
		lectures.add(newLecture);
		course.setLectures(lectures);
		s.saveLecture(newLecture);
		s.updateCourse(course);
		
		return SUCCESS;
		}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		NewLectureHandler.courseID = courseID;
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

	public Lecture getNewLecture() {
		return newLecture;
	}

	public void setNewLecture(Lecture newLecture) {
		this.newLecture = newLecture;
	}

	public String getNewLectureTitle() {
		return newLectureTitle;
	}

	public void setNewLectureTitle(String newLectureTitle) {
		this.newLectureTitle = newLectureTitle;
	}


	public String getNewLectureDescription() {
		return newLectureDescription;
	}

	public void setNewLectureDescription(String newLectureDescription) {
		this.newLectureDescription = newLectureDescription;
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
	

}