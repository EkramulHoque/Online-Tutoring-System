package org.tutor.struts2;

public class HelloWorld {
	private String name;
	private String firstname;
	private String report;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String execute() throws Exception{
		System.out.println(name);
		return "success";
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

}
