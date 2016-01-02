package org.tutor.struts2.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UnverifiedUser {
	@Id
	private String email;
	
	private String firstname, lastname, role, generatedCode,password;

	
	public UnverifiedUser(){}
	
	public UnverifiedUser(String firstname,String lastname,String role, String email, String password){
		this.firstname=firstname;
		this.lastname=lastname;
		this.role=role;
		this.email=email;
		this.password=password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGeneratedCode() {
		return generatedCode;
	}

	public void setGeneratedCode(String generatedCode) {
		this.generatedCode = generatedCode;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
