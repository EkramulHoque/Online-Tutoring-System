package org.tutor.struts2.pagehandlers;
import org.tutor.struts2.model.*;
import org.tutor.struts2.ormhelper.SessionBean;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExamHandler extends ActionSupport   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String userEmail= "";
	private int lectureID=1;
	
	
	private Lecture lecture;
	private Student student;


	public String [] userInput;
	int timeTaken;
	static char [] sorted;
	private static List<Question> options;
	
	static boolean check=false;
	 
	static char [] answers;
	int count=0;
	int duration=0;
	int numberOfQuestion=0;
	
	//assumption: Question bank has total 10 ques (3 easy, 4 moderate, 3 hard) - 5 to pick (2 easy, 2 moderate, 1 hard)
	int totalQues=15, easyTotalQues=5, moderateTotalQues=5, hardTotalQues=5; //total questions
	int total=7, easyQues=2, moderateQues=3, hardQues=2; //number of questions to select
	int easyMin=1, easyMax=5, modMin=6, modMax=10, hardMin=11, hardMax=15; //ranges of each level
	
	
private InputStream inputStream;
	
    public InputStream getInputStream() {
        return inputStream;
    }
    
	public int getNumberOfQuestion() {
		return numberOfQuestion;
	}
	public void setNumberOfQuestion(int numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	public int getLectureID() {
		return lectureID;
	}

	public void setLectureID(int lectureID) {
		this.lectureID = lectureID;
	}

	
	public ExamHandler(){
	}
	
	
	public List<Question> getOptions() {
		return options;
	}
	public void setOptions(List<Question> options) {
		this.options = options;
	}
	 
	public String[] getUserInput() {
		return userInput;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setUserInput(String[] userInput) {
		this.userInput = userInput;
	}
	
	public String make(){
		options= new ArrayList<Question>();
		//assumption: lecture id is lID
		
		System.out.println("lecture ID:"+lectureID);
		
		SessionBean s = new SessionBean();
		lecture = s.getLecture(lectureID);
		Quiz q = lecture.getQuiz();
		System.out.println("Quiz ID:"+q.getQuizID());
		List<Question> rawQ = q.getQuestions();
		
		
		List<Question> allQ = new ArrayList<Question>();
		int j=0;
		for (int i=0; i<rawQ.size(); i++){					
			j=0;
			for (j=0; j<allQ.size(); j++){
				if(rawQ.get(i).getQuestion().equals( allQ.get(j).getQuestion() )){
					break;
				}
			}
			
			if(j==allQ.size()){
				allQ.add(rawQ.get(i));
			}					
		}
		
		
		//random numbers will be generated here and stored in array indx
		int[] indx = new int[total];
		int n=0;
		ArrayList<Integer> randNum;
		
		//Easy - 2 out of 5 (Question 1-5)
		randNum = getRandomNumbers(easyMin,easyMax,easyQues);
		for (int i=0; i<easyQues; i++){
			indx[n]=(Integer) randNum.get(i);
			n++;
		}
		//Moderate - 3 out of 5 (Question 6-10)
		randNum = getRandomNumbers(modMin,modMax,moderateQues);
		for (int i=0; i<moderateQues; i++){
			indx[n]=(Integer) randNum.get(i);
			n++;
		}
		//Hard - 2 out of 5 (Question 11-15)
		randNum = getRandomNumbers(hardMin,hardMax,hardQues);
		for (int i=0; i<hardQues; i++){
			indx[n]=(Integer) randNum.get(i);
			n++;
		}
		
		/*for (int i=0; i<allQ.size(); i++){
			System.out.println(allQ.get(i).getQuestion());
		}
		for (int i=0; i<indx.length; i++){
			System.out.println(indx[i]);
		}*/
		
		answers= new char[total];
		System.out.print("Actual answers: ");
		for (int i=0; i<indx.length; i++){
			if(indx[i]==15)
				indx[i]=14;
			
			int ind = indx[i]-1;
			options.add(allQ.get(ind));
			answers[i]=  allQ.get(indx[i]-1).getAnswer().charAt(0);
			System.out.print(answers[i]);
		}
		System.out.println();
		//System.out.println("option size "+ options.size());
		this.duration=(Integer.parseInt(q.getDuration().getHours()+"")*3600 )+(Integer.parseInt(q.getDuration().getMinutes()+"")*60 )+ Integer.parseInt(q.getDuration().getSeconds()+"");	
		this.numberOfQuestion=indx.length;	
		
		
		return SUCCESS;
	}
	
	public String execute() throws Exception{
		int j=0;
		if(userInput!=null){
			
		 char [] temp=userInput[0].toCharArray();
		 sorted= new char[temp.length]; 
		 for(int i=0;i<temp.length;i++){
			 if(temp[i]==(',') || temp[i]==('N')){
			 }else{
			 sorted[j++]=temp[i];
			 }
		 }
		  
		 if(sorted[0]!=' '){
			 check=true;
		 }
		 System.out.print("Recieved answers: ");
		System.out.println(sorted);
		
		return SUCCESS;
		}
		return SUCCESS;
		
	}
	
	public String ajax() throws Exception {  
		
		Users e=(Users)ActionContext.getContext().getSession().get("user");
		
		if (check==false){
			inputStream = new StringBufferInputStream("0");
			return SUCCESS;
		}else{
		 
		 for(int i=0;i<answers.length;i++){
			 if(sorted[i]==answers[i])
				 count++;
		 }
		 
		 SessionBean ss = new SessionBean();
		 student = ss.getStudent(e.getEmail());
		 Script s1 = new Script();
		 lecture = ss.getLecture(lectureID);
		 Quiz q= lecture.getQuiz();
		 s1.setQuiz(q);
		 s1.setMarks(count);
		 s1.setStudent(student);
		 lecture.getQuiz().getScripts().add(s1);	
		 ss.saveScript(s1);
		 
		 String s =Integer.toString(count);
	     inputStream = new StringBufferInputStream(s);
        return SUCCESS;
		}
    }
	
	public ArrayList<Integer> getRandomNumbers(int min, int max, int count){
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>(); 

	    for (int i=0; i<count; i++) {    
	        int number;

	        do{
	            Random random = new Random();
				number = random.nextInt((max - min) + 1) + min;
	        } while (randomNumbers.contains(number));

	        randomNumbers.add(number);
	    }

	    return randomNumbers;
	}
	
 
	
}
