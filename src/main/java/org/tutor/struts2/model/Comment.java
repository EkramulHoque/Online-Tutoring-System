package org.tutor.struts2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Comment {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int commentID;
	@ManyToOne
	@JoinColumn(name="lectureID")
	private Lecture lecture;
	@OneToOne
	private Users user;
	private String comment;
	private Date date_time;
	
	
	
	public Comment(){
		this.date_time=new Date();
	}
	public Comment(Lecture lecture, Users user){
		this.lecture=lecture;
		this.user=user;
		this.date_time=new Date();
	}
	
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	
	public Lecture getLecture() {
		return lecture;
	}
	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	
}