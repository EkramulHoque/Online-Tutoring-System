package org.tutor.struts2.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class JsonTest extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> test;
	Map<String,Integer> testMap;
	
	public JsonTest(){
		test = new ArrayList<Integer>();
		testMap = new HashMap<String, Integer>();
	}

	
	
	public ArrayList<Integer> getTest() {
		return test;
	}



	public void setTest(ArrayList<Integer> test) {
		this.test = test;
	}



	public String execute(){
		for (int i=0; i<10; ++i){
			test.add(i);
		}
		
		for (int i=0; i<10; ++i){
			testMap.put("Course"+i, (int)Math.floor(Math.random()*100));
		}
		return SUCCESS;
	}
}
