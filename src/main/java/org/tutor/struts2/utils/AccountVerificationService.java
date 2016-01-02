package org.tutor.struts2.utils;



import org.tutor.struts2.model.UnverifiedUser;
import org.tutor.struts2.model.Users;
import org.tutor.struts2.model.Instructor;
import org.tutor.struts2.model.Student;
import org.tutor.struts2.ormhelper.InstructorDAO;
import org.tutor.struts2.ormhelper.StudentDAO;
import org.tutor.struts2.ormhelper.UnverifiedUserDAO;

import com.opensymphony.xwork2.ActionContext;

public class AccountVerificationService {
	
	private String email = (String)ActionContext.getContext().getSession().get("unverified");
	private String id;
	
	

	// returns the generated Code for the confirmation Email
	public String sendConfirmationEmail(UnverifiedUser user){
		ConfirmationMailSenderService mailSender = new ConfirmationMailSenderService(user.getEmail());
		user.setGeneratedCode(mailSender.getConfirmationCode());
		UnverifiedUserDAO dbSession = new UnverifiedUserDAO();
		dbSession.save(user);
		mailSender.execute();
		
		return mailSender.getConfirmationCode();
	}
	
	public String resendConfirmationEmail(){
		UnverifiedUserDAO dbSession = new UnverifiedUserDAO();
		
		try {
			email = (String)ActionContext.getContext().getSession().get("unverified");
			UnverifiedUser user= dbSession.findById(email);
			ConfirmationMailSenderService mailSender = new ConfirmationMailSenderService(email);
			String newCode=mailSender.getConfirmationCode();
			user.setGeneratedCode(newCode);
			dbSession.save(user);
			mailSender.execute();
			return "success";
			
		} catch (Exception e){
			return "login";
		}
		
	}
	
	public String verifyUser(){
		Users u= null;
		Instructor instructor=null;
		Student student =null;
		try{
		UnverifiedUserDAO dbSession = new UnverifiedUserDAO();
		UnverifiedUser user=dbSession.findById(email);
		if (user.getGeneratedCode().equals(id)){
			
			if (user.getRole().equals("instructor")){
				instructor = new Instructor(user.getEmail(),user.getPassword());
				instructor.setFirstname(user.getFirstname());
				instructor.setLastname(user.getLastname());
				instructor.setPassword(user.getPassword());
				
				ActionContext.getContext().getSession().put("user", instructor);
				dbSession.delete(user);
				new InstructorDAO().save(instructor);
			} else {
				student = new Student(user.getEmail(),user.getPassword());
				student.setFirstname(user.getFirstname());
				student.setLastname(user.getLastname());
				student.setPassword(user.getPassword());
				
				ActionContext.getContext().getSession().put("user", student);
				dbSession.delete(user);
				new StudentDAO().save(student);
			}
			ActionContext.getContext().getSession().remove("unverified");
			
		}
		if (user.getRole().equals("instructor"))
			return "successInstructor";
		else return "successStudent";
		} catch (Exception e){
			System.out.println(email);
			e.printStackTrace();
			return "login";
		}
	}
	
	public String unverifiedViewer(){
		try{
			email = (String) ActionContext.getContext().getSession().get("unverified");
			
		}catch (Exception e){
			return "login";
		}
		return "success";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
