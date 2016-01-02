package org.tutor.struts2.pagehandlers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tutor.struts2.login.UserDetails;
import org.tutor.struts2.model.UnverifiedUser;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.ormhelper.OnlineTutorDAOInterface;
import org.tutor.struts2.ormhelper.SessionBean;
import org.tutor.struts2.ormhelper.UnverifiedUserDAO;
import org.tutor.struts2.ormhelper.UsersDAO;
import org.tutor.struts2.utils.MailSender;
import org.tutor.struts2.utils.AccountVerificationService;
import org.tutor.struts2.utils.ConfirmationMailSenderService;

import com.opensymphony.xwork2.ActionSupport;

public class SignUpPageHandler extends ActionSupport {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	String firstname, lastname, email, password, confirmPass;
	String roll="student";
	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	
	@Override
	public void validate(){
		
		if (email.length()<=0 || password.length()<=0 || confirmPass.length()<=0
				|| firstname.length()<=0 || lastname.length()<=0){
			addFieldError("others","Please Enter All The Required Field");
			return;
		}
		
		if (!password.equals(confirmPass)){
			addFieldError("password","Password Mismatch");
		}
		try{
			if (roll.equals(null)){
				addFieldError("acType","You haven't selected an account type");
			}
		} catch (java.lang.NullPointerException exception){
			addFieldError("acType","You haven't selected an account type");
		}
		
		OnlineTutorDAOInterface<Users, String> s = new UsersDAO();
		
		if (((UsersDAO) s).doesUserExists(email) ){
			
			addFieldError("email", "Account With The Provided Email Already Exists");
			
			return;
		}
		
		OnlineTutorDAOInterface<UnverifiedUser, String> q = new UnverifiedUserDAO();
		
		if (((UnverifiedUserDAO) q).doesUnverifiedUserExists(email) ){
			
			addFieldError("email", "Account With The Provided Email Already Exists but still "
					+ "not verified. Please check email for verification link.");
			return;
		}
		
	}
	
	public String execute(){
		
		
		UnverifiedUser user = new UnverifiedUser(firstname, lastname, roll, email,password);
		
		System.out.println(roll);
		
		
		if (roll.equals("student"))
			user.setRole("student");
		else user.setRole("instructor");
		
		
		
		AccountVerificationService verify = new AccountVerificationService();
		verify.sendConfirmationEmail(user);
		
		
		
		return SUCCESS;
		
	}


}
