package org.tutor.struts2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Instructor extends Users {
	@OneToMany(mappedBy="instructor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@NotFound(action=NotFoundAction.IGNORE)
	private List<Course> instructedCourses = new ArrayList<Course>();
	
	public Instructor(){
		super();
		super.setRole("instructor");
		super.setBio("");
	}
	
	public Instructor(String email, String password){
		super(email, password);
		super.setRole("instructor");
		super.setBio("blank");
		super.setPhotoPath("no-photo-male.png");
	}

	public List<Course> getInstructedCourses() {
		return instructedCourses;
	}

	public void setInstructedCourses(List<Course> instructedCourses) {
		this.instructedCourses = instructedCourses;
	}

	

}
