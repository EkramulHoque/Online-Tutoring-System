package org.tutor.struts2.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Script {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int scriptID;
	@ManyToOne
	private Quiz quiz;
	@OneToOne
	private Users student;
	private double marks;
	
	public Script(){}
	public Quiz getQuiz() {
		return quiz;
	}
	
	public int getScriptID() {
		return scriptID;
	}
	public void setScriptID(int scriptID) {
		this.scriptID = scriptID;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public Users getStudent() {
		return student;
	}
	public void setStudent(Users student) {
		this.student = student;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	
}
