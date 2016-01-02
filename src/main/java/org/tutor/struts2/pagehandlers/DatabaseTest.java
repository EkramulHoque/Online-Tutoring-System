package org.tutor.struts2.pagehandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.tutor.struts2.model.Lecture;
import org.tutor.struts2.model.Media;
import org.tutor.struts2.model.Question;
import org.tutor.struts2.model.Quiz;
import org.tutor.struts2.ormhelper.SessionBean;

public class DatabaseTest {
	private static int lectureID=1;
	private static Lecture lecture;
	private static List<Question> options= new ArrayList<Question>();

	//assumption: Question bank has total 10 ques (3 easy, 4 moderate, 3 hard) - 5 to pick (2 easy, 2 moderate, 1 hard)
		static int totalQues=15, easyTotalQues=5, moderateTotalQues=5, hardTotalQues=5; //total questions
		static int total=7, easyQues=2, moderateQues=3, hardQues=2; //number of questions to select
		static int easyMin=1, easyMax=5, modMin=6, modMax=10, hardMin=11, hardMax=15; //ranges of each level

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//assumption: lecture id is lID
				SessionBean s = new SessionBean();
				lecture = s.getLecture(lectureID);
				Quiz q = lecture.getQuiz();
				List<Question> rawQ = q.getQuestions();
				List<Media> rawM = lecture.getMaterials();
				
				System.out.println("rawM: "+rawQ.size());
				
				List<Media> allM = new ArrayList<Media>();
				int j=0;
				for (int i=0; i<rawM.size(); i++){					
					j=0;
					for (j=0; j<allM.size(); j++){
						if(rawM.get(i).getMediaTitle().equals( allM.get(j).getMediaTitle() )){
							break;
						}
					}
					
					if(j==allM.size()){
						allM.add(rawM.get(i));
					}					
				}
				System.out.println("allM: "+allM.size());
				
				List<Question> allQ = new ArrayList<Question>();
				//boolean unique;
				j=0;
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
				
				System.out.println("allQ: "+allQ.size());
				//random numbers will be generated here and stored in array indx
				int[] indx = new int[total];
				int n=0;
				ArrayList<Integer> randNum;
				
				//Easy - 2 out of 5 (Question 1-5)
				randNum = getRandomNumbers(easyMin,easyMax,easyQues);
				for (int i=0; i<easyQues; i++){
					indx[n]= randNum.get(i);
					System.out.println("Gave ->"+randNum.get(i));
					System.out.println("Stored ->"+indx[n]);
					n++;
				}
				//Moderate - 3 out of 5 (Question 6-10)
				randNum = getRandomNumbers(modMin,modMax,moderateQues);
				for (int i=0; i<moderateQues; i++){
					indx[n]= randNum.get(i);
					System.out.println("Gave ->"+randNum.get(i));
					System.out.println("Stored ->"+indx[n]);
					n++;
				}
				//Hard - 2 out of 5 (Question 11-15)
				randNum = getRandomNumbers(hardMin,hardMax,hardQues);
				for (int i=0; i<hardQues; i++){
					indx[n]=randNum.get(i);
					System.out.println("Gave ->"+randNum.get(i));
					System.out.println("Stored ->"+indx[n]);
					n++;
				}
				
				
				for (int i=0; i<indx.length; i++){
					options.add(new Question(allQ.get(indx[i]-1).getQuestion(), 
							i+1, 
							allQ.get(indx[i]-1).getOption1(), 
							allQ.get(indx[i]-1).getOption2(), 
							allQ.get(indx[i]-1).getOption3(), 
							allQ.get(indx[i]-1).getOption4(), 
							allQ.get(indx[i]-1).getAnswer()));
				}
				
				//this.duration=(Integer.parseInt(q.getDuration().getHours()+"")*3600 )+(Integer.parseInt(q.getDuration().getMinutes()+"")*60 )+ Integer.parseInt(q.getDuration().getSeconds()+"");	
				//this.numberOfQuestion=indx.length;	

	}
	
	static ArrayList<Integer> getRandomNumbers(int min, int max, int count)
	{
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>(); 

	    for (int i=0; i<count; i++) 
	    {    
	        int number;

	        do
	        {
	            Random random = new Random();
				number = random.nextInt((max - min) + 1) + min;
				System.out.println("Actual ->"+number);
	        } while (randomNumbers.contains(number));

	        randomNumbers.add(number);
	    }

	    return randomNumbers;
	}

}
