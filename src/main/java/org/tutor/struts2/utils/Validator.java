package org.tutor.struts2.utils;

public class Validator {
	
	public boolean matchPass(String pass, String confPass){
		if (pass.equals(confPass))
			return true;
		else return false;
	}

}
