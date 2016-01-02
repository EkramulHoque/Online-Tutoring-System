package org.tutor.struts2.login;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLoginCredential {
	@Id
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
