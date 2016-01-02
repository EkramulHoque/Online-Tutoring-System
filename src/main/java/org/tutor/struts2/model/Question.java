package org.tutor.struts2.model;

import javax.persistence.Embeddable;
@Embeddable
public class Question {
	private String question, option1, option2, option3, option4, answer;
	private int questionNum;
	
	public Question(){
	}
	
	public Question(String q,int i,String o1,String o2,String o3,String o4,String answer){
		this.question=q;
		this.questionNum=i;
		this.option1=o1;
		this.option2=o2;
		this.option3=o3;
		this.option4=o4;
		this.answer=answer;
		
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	
	
}