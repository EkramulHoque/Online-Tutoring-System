package org.tutor.struts2.pagehandlers;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.tutor.struts2.model.*;
import org.tutor.struts2.ormhelper.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LectureViewHandler extends ActionSupport {
	
	 
	private static final long serialVersionUID = 1L;
	
	static String mediaLocation="../../assets/frontend/layout/media/";
	String location="D:/Work/hello/src/main/webapp/metronic/assets/frontend/layout/media/";
	
	
	private InputStream fileInputStream;
	
	Lecture l1=new Lecture();
	String title;
	String description;
	private String file="";
	String userComment; 
	String userDownload;
	List<String> downLoadFiles;
	List<Comment> Comment;
	List<Media> media;
	static int lectureID;
	String videoPath;
	String role="";
	
	private List<Course> courses;
	private List<Course> otherCourses;
	private Student student;
	private Instructor instructor;
		
	
	
	public int getLectureID() {
		return lectureID;
	}


	public void setLectureID(int lectureID) {
		this.lectureID = lectureID;
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


		public Student getStudent() {
			return student;
		}


		public void setStudent(Student student) {
			this.student = student;
		}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getVideoPath() {
		return videoPath;
	}


	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}


	public String getUserDownload() {
		return userDownload;
	}


	public void setUserDownload(String userDownload) {
		this.userDownload = userDownload;
	}


	public List<String> getDownLoadFiles() {
		return downLoadFiles;
	}


	public void setDownLoadFiles(List<String> downLoadFiles) {
		this.downLoadFiles = downLoadFiles;
	}


	
	public List<Media> getMedia() {
		return media;
	}


	public void setMedia(List<Media> media) {
		this.media = media;
	}



	
	public String getUserComment() {
		return userComment;
	}


	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}



	
 
 

	public String execute(){
 
		
		///////Session Bean/////////////////////////////////////////////////////////////////////////////
		SessionBean session= new SessionBean();
		Users e=(Users)ActionContext.getContext().getSession().get("user");
			
		if(e==null){  		
    		return ERROR;
    	}
    	if(e.getRole().equals("instructor")){	
    		role="instructor";
    	}else{
    		
    		role="student";
    	}
    	 
    	
    	String email=e.getEmail();
		l1=session.getLecture(lectureID);
		this.description=l1.getLectureDescription();
		this.title=l1.getLectureTitle();	
		media=l1.getMaterials();
		
		List<Media> allQ = new ArrayList<Media>();
		int j=0;
		for (int i=0; i<media.size(); i++){					
			j=0;
			for (j=0; j<allQ.size(); j++){
				if(media.get(i).getPath().equals( allQ.get(j).getPath()) || media.get(i).getType().equals("empty")){				
					break;
				}
			}
			
			if(j==allQ.size()){
				allQ.add(media.get(i));
			}					
		}
		
		
		media=allQ;
		downLoadFiles=new ArrayList<String>();
		
		for(int i=0;i<media.size();i++){
			if(media.get(i).getType().equals("mp4") || media.get(i).getType().equals(".mp4") || media.get(i).getType().equals("mpeg")  )
			{
				
				videoPath=media.get(i).getPath();
			}
				else
			{
					downLoadFiles.add(media.get(i).getPath());
			
			}
		}
		videoPath=mediaLocation+videoPath;	
		
		
		Comment=session.findCommentByLectureId(lectureID);
		
		int length=downLoadFiles.size();
		if(length==1){}else{
			List<String> temp=new ArrayList<String>();
			for(int i=1;i<length;i++)
			{ 
				temp.add(downLoadFiles.get(i));
			}
			downLoadFiles=temp;
		}
		 
		 
    	 if(role.equals("instructor")){
    		
    	    	instructor= session.getInstructor(email);
    	    	courses=session.findByInstructor(email);
    			System.out.println(instructor.getFirstname()+" "+instructor.getLastname() );
    			role="instructor";
    		 return "instructor";
    	 }
    	 else{
    		 
    		student = session.getStudent(email);
 			courses = session.findByStudent(email);
 			otherCourses = session.findOtherCoursesByStudent(email);
		
 			System.out.println(student.getFirstname()+" "+student.getLastname() );
 			role="student";
    		 
    		 return "student";
    		 
    	 }
    	 
		
	
	}
	public String download() throws Exception{
		
		this.file=userDownload;
		if(file.equals("empty"))
			return "Lecture";
		
		 fileInputStream = new FileInputStream(new File(location+userDownload));	 
		return SUCCESS;
	}
	
	public String commentPass(){
		///////Session Bean/////////////////////////////////////////////////////////////////////////////
		Users e=(Users)ActionContext.getContext().getSession().get("user");
    	if(e==null){  		
    		return ERROR;
    	}
    	
    	SessionBean session= new SessionBean();
		l1=session.getLecture(lectureID);
		Comment comment = new Comment();
		comment.setUser(e);
		comment.setComment(this.userComment);
		comment.setLecture(l1);
		
		Comment=session.findCommentByLectureId(lectureID);
		Comment.add(comment);
		session.updateLecture(l1);
		session.saveComment(comment);
		 
		
		return SUCCESS;
	}
	


	public List<Comment> getComment() {
		return Comment;
	}


	public void setComment(List<Comment> comment) {
		Comment = comment;
	}


	public InputStream getFileInputStream() {
		return fileInputStream;
	}


	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

 

	


}
