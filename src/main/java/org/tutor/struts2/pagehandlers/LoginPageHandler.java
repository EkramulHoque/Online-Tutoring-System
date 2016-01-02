package org.tutor.struts2.pagehandlers;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.ormhelper.UnverifiedUserDAO;
import org.tutor.struts2.ormhelper.UsersDAO;

import com.opensymphony.xwork2.ActionSupport;

public class LoginPageHandler extends ActionSupport implements SessionAware {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1299666556996960827L;
	private String username;
	private String email;
	private String password;
	private Map<String,Object> session;
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Map<String, Object> getSession() {
		return session;
	}


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


	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	
	public Users isValidUser(String email, String password){
		UsersDAO dbSession = new UsersDAO();
		Users realUser = dbSession.findById(email);
		if (realUser!=null){
			if (realUser.getPassword().equals(password))
				return realUser;
		}
		return null;
			
	}
	
	@Override
	public String execute(){
		System.out.println(email);
		System.out.println(password);
		//clearFieldErrors();
		Users user = (Users)session.get("user");
		if (user!=null && user.getRole().equals("instructor"))
			return "successInstructor";
		else if (user!=null && user.getRole().equals("student"))
			return "successStudent";
		else {
			if (isUnverifiedUser(email)){
				session.put("unverified", email);
				System.out.println("**********");
				return "unverifiedLogin";
			}
			System.out.println("!!!!!!!!!!!!!!!");
			Users u = isValidUser(email,password);
			if (u!=null){
				session.put("user", u);
				if (u.getRole().equals("instructor"))
					return "successInstructor";
				else return "successStudent";
			} else {
				addFieldError("invalid","Invalid username or password");
			}
		}
		return INPUT;
	}


	public boolean isUnverifiedUser(String email) {
		
		UnverifiedUserDAO u=new UnverifiedUserDAO();
		System.out.println(u.doesUnverifiedUserExists(email));
		
		
		return new UnverifiedUserDAO().doesUnverifiedUserExists(email);
		
	}
	

}
