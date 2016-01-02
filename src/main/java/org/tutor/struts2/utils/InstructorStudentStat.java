package org.tutor.struts2.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Instructor;
import org.tutor.struts2.model.Lecture;
import org.tutor.struts2.model.Script;
import org.tutor.struts2.model.Student;
import org.tutor.struts2.ormhelper.SessionBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InstructorStudentStat extends ActionSupport {

	private static final long serialVersionUID = 1L;
	Map<String,Integer> testMap;
	String courseID;
	List<String> firstname;
	List<String> lastname;
	List<String> lecture;
	List<Integer> marks;
	
	public InstructorStudentStat(){
		testMap = new HashMap<String, Integer>();
		firstname = new ArrayList<String>();
		lastname =new ArrayList<String>();
		lecture = new ArrayList<String>();
		marks = new ArrayList<Integer>();
		//courseID="CSE470";
	}

	

	public String execute(){
		try{
		Instructor ins = (Instructor)ActionContext.getContext().getSession().get("user");
		System.out.println(ins.getFirstname());

		System.out.println(courseID);
		SessionBean session = new SessionBean();
		List<Course> instList = session.findByInstructor(ins.getEmail());
		boolean z = false;
		for (Course cr : instList){
			if (cr.getCourseID().equals(courseID)){
				z=true;
			}
		}
		if (z==false)
			return ERROR;
		
		List<Script> allQ = new ArrayList<Script>();
		List<Lecture> lectures= session.getLecturesByCourse(courseID);
		for (Lecture l: lectures){
		//	System.out.println(l.getLectureTitle());
			List<Script> scripts=l.getQuiz().getScripts();
			
			scripts=l.getQuiz().getScripts();
			  System.out.println("Raw: "+scripts.size());
			 
					//Student u=(Student) ActionContext.getContext().getSession().get("user");
					
				  int j=0;
					for (int i=0; i<scripts.size(); i++){					
						j=0;
						for (j=0; j<allQ.size(); j++){
							if(scripts.get(i).getScriptID()==allQ.get(j).getScriptID()){
								break;
							}
						}
						
						if(j==allQ.size()){
							allQ.add(scripts.get(i));
						}					
					}
					scripts=allQ;
					System.out.println("first filter: "+scripts.size());
					
			
			
			
			for (Script s: scripts){
				
				if(s.getQuiz().getLecture().getLectureID()==l.getLectureID()){
				Student u=(Student)s.getStudent();
				firstname.add(u.getFirstname());
				lastname.add(u.getLastname());
				lecture.add(l.getLectureTitle());
				marks.add((int) s.getMarks());
				}
			}
		}
		} catch(Exception e){
			return ERROR;
		}
		return SUCCESS;
	}








	public List<String> getFirstname() {
		return firstname;
	}



	public void setFirstname(List<String> firstname) {
		this.firstname = firstname;
	}



	public List<String> getLastname() {
		return lastname;
	}



	public void setLastname(List<String> lastname) {
		this.lastname = lastname;
	}



	public List<String> getLecture() {
		return lecture;
	}



	public void setLecture(List<String> lecture) {
		this.lecture = lecture;
	}



	public List<Integer> getMarks() {
		return marks;
	}



	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}



	public String getCourseID() {
		return courseID;
	}



	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}



	public Map<String, Integer> getTestMap() {
		return testMap;
	}








	public void setTestMap(Map<String, Integer> testMap) {
		this.testMap = testMap;
	}
}
