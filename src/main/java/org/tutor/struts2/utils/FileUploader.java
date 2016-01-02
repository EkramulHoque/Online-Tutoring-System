package org.tutor.struts2.utils;
import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Time;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.tutor.struts2.model.*;

import org.tutor.struts2.ormhelper.SessionBean;
 


public class FileUploader extends ActionSupport implements SessionAware {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File myFile;
	   private String myFileContentType;
	   private String myFileFileName;
	   private String destPath;
	   private String [] bank;
		private int i=0;
		Lecture lecture=new Lecture();
		
	static	int lectureID;
	
	int hour,minute,second;
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
	String duration;
	
	private List<Course> courses;
	private List<Course> otherCourses;
	private Student student;
	private Instructor instructor;
	Lecture l1=new Lecture();	
		

	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
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
	   public String execute()
	   {
	      /* Copy file to a safe location */
		  String location="D:/Work/hello/src/main/webapp/metronic/assets/frontend/layout/media/";
	      destPath = "D:/";

	      try{
	     	 System.out.println("Src File name: " + myFile);
	     	 System.out.println("Dst File name: " + myFileFileName);
	     	    	 
	     	if(myFileFileName==null || myFileFileName.equals("")){
	     		 return ERROR;
	     	 }
	     	 
	     	 
	     	 File destFile  = new File(location, myFileFileName);
	    	 FileUtils.copyFile(myFile, destFile);
	  
	      }catch(IOException e){
	         e.printStackTrace();
	         return ERROR;
	      }
	      
	      String e=readExcelFile(location+myFileFileName);
	      if(e.equals("error")){
	    	  return ERROR;
	    	  
	      }else{
	      return SUCCESS;}
	     
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
	   public int getLectureID() {
		return lectureID;
	}
	public void setLectureID(int lectureID) {
		this.lectureID = lectureID;
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
		public String readExcelFile(String filename){
			
			  try
		        {
				  
				 
					
					SessionBean session=new SessionBean();
					lecture=session.getLecture(lectureID);
					System.out.println("Lecture:"+lectureID);
					Quiz test = new Quiz();
					//test.setQuizID(lecture.getQuiz().getQuizID());
					test.setQuizName("Quiz 2");
					test.setDuration(new Time(0,2,0));
					test.setLecture(lecture);
					
				  
		            FileInputStream file = new FileInputStream(new File(filename));            
		            XSSFWorkbook workbook = new XSSFWorkbook(file);
		            XSSFSheet sheet = workbook.getSheetAt(0);  
		            Iterator<Row> rowIterator = sheet.iterator();
		            i=0;
		            bank=new String[sheet.getPhysicalNumberOfRows()];
		            while (rowIterator.hasNext())
		            {
		                Row row = rowIterator.next();	                
		                Iterator<Cell> cellIterator = row.cellIterator();	                 
		                while (cellIterator.hasNext())
		                {
		                    Cell cell = cellIterator.next();                    
		                    switch (cell.getCellType())
		                    {
		                        case Cell.CELL_TYPE_NUMERIC:
		                        	bank[i]=bank[i]+cell.getNumericCellValue() + "#";
		                            System.out.print(cell.getNumericCellValue() + "#");
		                            break;
		                        case Cell.CELL_TYPE_STRING:
		                        	bank[i]=bank[i]+cell.getStringCellValue() + "#";
		                            System.out.print(cell.getStringCellValue() + "#");
		                            break;
		                    }
		                }
		                i++;
		                System.out.println("");
		            }
		            file.close();
		            
		            
		            String [] main=new String [bank.length];
		            
		            for(int j=0;j<bank.length;j++){
		            	String [] temp=bank[j].split("null");
		            	main[j]=temp[1];           	            	 	
		            }
		            System.out.println("Number of Questions:"+main.length);
		            if(main.length<15){
		            	addFieldError("invalid","You must give at least 15 questions in your excel file");
		            	return ERROR;
		            }
		             for(int j=0;j<main.length;j++){
		            	String [] temp=main[j].split("#");	
		            	 System.out.println("Question Format:"+ temp.length);
		            	if(temp.length!=7){
				            	addFieldError("invalid","Check the columns for format");
				            	return ERROR;
				            }
		            	
		            	Question question=new Question(temp[1],j+1,temp[2],temp[3],temp[4],temp[5],temp[6]);
		            	test.getQuestions().add(question);      		            	
		             
		            }
		            
		             
		             if(hour<0)
		            	 hour=0;
		             if(minute<0)
		            	 minute=0;
		             if(second<0)
		            	 second=0;
		             
		             if(minute>60)
		            	 minute=59;
		             if(second>60)
		            	 second=59;
		             test.getDuration().setHours(hour);
		             test.getDuration().setMinutes(minute);
		             test.getDuration().setSeconds(second);
		              
		             
		            lecture.setQuiz(test);	    		
		           
		    		session.updateLecture(lecture);
		             
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		            return ERROR;
		        }
			  addFieldError("invalid","Successful");
			  return SUCCESS;
		}
		public void setSession(Map<String, Object> arg0) {
			// TODO Auto-generated method stub
			
		}
		
}
