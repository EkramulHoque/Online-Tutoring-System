package org.tutor.struts2.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

@Entity
public class Quiz {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int quizID;
	private String quizName;
	@OneToOne(mappedBy="quiz") 
	@NotFound(action=NotFoundAction.IGNORE)
	private Lecture lecture;
	private Time duration;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="quiz", cascade = CascadeType.ALL)
	private List<Script> scripts = new ArrayList<Script>(); 
	@ElementCollection (fetch=FetchType.EAGER)
	@Embedded
	@GenericGenerator(name = "hilo-gen", strategy="hilo")
	@CollectionId (columns = { @Column (name="quesID")}, generator="hilo-gen", type= @Type (type="int"))
	private List<Question> questions= new ArrayList<Question>();
	
	
	
	public Quiz(){}
	
	
	public int getQuizID() {
		return quizID;
	}
	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}

	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public Lecture getLecture() {
		return lecture;
	}
	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}


	public List<Script> getScripts() {
		return scripts;
	}


	public void setScripts(List<Script> scripts) {
		this.scripts = scripts;
	}
	
	
}