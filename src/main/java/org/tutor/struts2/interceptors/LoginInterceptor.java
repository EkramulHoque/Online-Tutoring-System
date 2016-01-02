/**
 * This Interceptor class is used for authenticating Instructor account
 */

package org.tutor.struts2.interceptors;

import java.util.Map;

import org.tutor.struts2.model.Users;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6772439841915849496L;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		
		// variable to retrieve User object from current session
		Map <String, Object> session = invocation.getInvocationContext().getSession();
		Users user = (Users)session.get("user");
		
		if (session.get("unverified")!=null){
			System.out.println("unverified not null");
			return "unverified";
		}
		//checks for user role and return action accordingly
		if (user==null  || user.getRole().equals("student"))
			return ActionSupport.LOGIN;
		return invocation.invoke();
	}

}
