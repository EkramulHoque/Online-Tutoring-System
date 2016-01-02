package org.tutor.struts2.utils;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Instructor;
import org.tutor.struts2.model.Lecture;
import org.tutor.struts2.model.Media;
import org.tutor.struts2.model.Student;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.ormhelper.SessionBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.List;
public class VideoUpload extends ActionSupport {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private File myFile;
	   private String myFileContentType;
	   private String myFileFileName;
	   private String destPath;
	   String location="D:/Work/hello/src/main/webapp/metronic/assets/frontend/layout/media/";
	   Lecture lecture= new Lecture();
	   
	   static	int lectureID;
	   Lecture l1=new Lecture();
	   private List<Course> courses;
		private List<Course> otherCourses;
		private Student student;
		private Instructor instructor;

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

		public Instructor getInstructor() {
			return instructor;
		}

		public void setInstructor(Instructor instructor) {
			this.instructor = instructor;
		}

	public int getLectureID() {
		return lectureID;
	}

	public void setLectureID(int lectureID) {
		this.lectureID = lectureID;
	}

	public String display()
		{
		
		
		
		SessionBean session= new SessionBean();
		Users e=(Users)ActionContext.getContext().getSession().get("user");
		String role;	
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
		
	   	 if(role.equals("instructor")){
	    		
 	    	instructor= session.getInstructor(email);
 	    	courses=session.findByInstructor(email);
 			System.out.println(instructor.getFirstname()+" "+instructor.getLastname() );
 			role="instructor";
 		 return NONE;
 	 }
 	 else{
 		 
 		student = session.getStudent(email);
			courses = session.findByStudent(email);
			otherCourses = session.findOtherCoursesByStudent(email);
		
			System.out.println(student.getFirstname()+" "+student.getLastname() );
			role="student";
 		 
			return NONE;
 		 
 	 }
 	 
		}
	   
	   public String execute() throws Exception
	   {
	      /* Copy file to a safe location */
	      destPath = "D:/";
	      
	      
	      try{
	    	  
	     	 System.out.println("Src File name: " + myFile);
	     	 System.out.println("Dst File name: " + myFileFileName);
	     	 
	     	if(myFileFileName==null || myFileFileName.equals("")){
	     		 return ERROR;
	     	 }
	     	    	 
	     	 File destFile  = new File(location, myFileFileName);
	    	 FileUtils.copyFile(myFile, destFile);
	    	 
	    	 SessionBean session=new SessionBean();
	    	 	
				lecture=session.getLecture(lectureID);
				System.out.println(lectureID);
				System.out.println(lecture.getLectureTitle());
			
	    	 
	    	String [] split=myFileFileName.split("\\.");
	    	System.out.println(split[0]);
	    	System.out.println(split[1]);
	    	
	    	Media media=new Media();
	 		media.setMediaTitle(split[0]);
	 		media.setType(split[1]);
	 		media.setPath(myFileFileName);
	 		
	 		
	 		lecture.getMaterials().add(media);
	 		session.updateLecture(lecture);
	  
	      }catch(IOException e){
	         e.printStackTrace();
	         
	         return ERROR;
	      }
	      
	     
	      return SUCCESS;
	   }
	   public File getMyFile() {
	      return myFile;
	   }
	   public void setMyFile(File myFile) {
	      this.myFile = myFile;
	   }
	   public String getMyFileContentType() {
	      return myFileContentType;
	   }
	   public void setMyFileContentType(String myFileContentType) {
	      this.myFileContentType = myFileContentType;
	   }
	   public String getMyFileFileName() {
	      return myFileFileName;
	   }
	   public void setMyFileFileName(String myFileFileName) {
	      this.myFileFileName = myFileFileName;
	   }
		 
		
}
