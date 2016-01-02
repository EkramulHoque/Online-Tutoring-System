/**
 * This class performs the logout action for any of the session
 * It clears all the session attributes
 */
package org.tutor.struts2.pagehandlers;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3528082644952504136L;
	
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	/**
	 * method that removes all session attributes
	 */
	public String execute(){
		try{
			System.out.println("user remve");
			session.remove("user");
			
		} catch (Exception e){
			System.out.println("!@#$%^&*(!@#$%^&*");
		}
		
		try{
			session.remove("unverified");
			System.out.println("session remove");
		} catch (java.lang.NullPointerException e){
			System.out.println("/*/*/*/*/*");
			return SUCCESS;
		}
		return SUCCESS;
	}

}
