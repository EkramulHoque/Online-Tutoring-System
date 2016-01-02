package org.tutor.struts2.utils;

import com.opensymphony.xwork2.ActionContext;

public class ConfirmationMailSenderService extends MailSender {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7284328521995282213L;

	private String confirmationCode;
	private String confirmationLink;
	private ConfirmationMailSenderService(){
		this.setFrom("tutorhub22@gmail.com");
		this.setPassword("hellohi5");
	}
	
	public ConfirmationMailSenderService(String to){
		this();
		this.setTo(to);
		confirmationCode= makeConfirmationCode();
		generateConfirmationLink("localhost", "8080");
		confirmationLink= getConfirmationLink();
		this.setSubject("Confimation Email at online tutor account");
		this.setBody("This is an auto generated message\n Please click on the link below at"
				+ " onlinetutor website within 24 hours to confirm your account.\n"
				+ confirmationLink);
	
		
	}
	
	public String makeConfirmationCode(){
		System.out.println(this.getTo());
		String [] temp = this.getTo().split("@");
		int i = (int) (Math.random()*100000);
		return temp[0]+i+this.getFrom().split("@")[0];
		
		
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	
	public String getConfirmationLink() {
		return confirmationLink;
	}

	public void setConfirmationLink(String confirmationLink) {
		this.confirmationLink = confirmationLink;
	}
	
	public void generateConfirmationLink(String hostname, String port){
		setConfirmationLink("http://"+ hostname+":"+port+"/hello/metronic/templates/frontend/"
				+ "verifyUser?id="+getConfirmationCode()+"&email="+this.getTo());
		
	}
	
	
	

}
