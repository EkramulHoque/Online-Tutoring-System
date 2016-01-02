package org.tutor.struts2.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;


@Entity
public class Lecture {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int lectureID;
	private String lectureTitle, lectureDescription;
	@ManyToOne
	@JoinColumn(name="Course_ID")
	private Course course;
	@ElementCollection (fetch=FetchType.EAGER)
	@Embedded
	@GenericGenerator(name = "hilo-gen", strategy="hilo")
	@CollectionId (columns = { @Column(name="mediaID")}, generator="hilo-gen", type= @Type (type="int") )
	private List<Media> materials = new ArrayList<Media>();
	@OneToMany(mappedBy="lecture", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments = new ArrayList<Comment>();
	@OneToOne (fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@NotFound(action=NotFoundAction.IGNORE)
	private Quiz quiz;
	
	public Lecture(){}
	public Lecture(Course course){
		this.course=course;
	}
	public int getLectureID() {
		return lectureID;
	}
	public void setLectureID(int lectureID) {
		this.lectureID = lectureID;
	}
	public String getLectureTitle() {
		return lectureTitle;
	}
	public void setLectureTitle(String lectureTitle) {
		this.lectureTitle = lectureTitle;
	}
	public String getLectureDescription() {
		return lectureDescription;
	}
	public void setLectureDescription(String lectureDescription) {
		this.lectureDescription = lectureDescription;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public List<Media> getMaterials() {
		return materials;
	}
	public void setMaterials(List<Media> materials) {
		this.materials = materials;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	

}