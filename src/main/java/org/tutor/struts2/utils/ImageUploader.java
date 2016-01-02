package org.tutor.struts2.utils;
 
import java.util.Map;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;
import java.io.IOException; 
import org.tutor.struts2.model.Users;
import org.tutor.struts2.ormhelper.SessionBean;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

 
public class ImageUploader extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	private File myFile;
	   private String myFileContentType;
	   private String myFileFileName;
	   private String destPath;
	   
	   private String username;
		public String email;
		public String password;
	   
	   public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
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

	 

		public Users isValidUser(String email, String password){
			SessionBean dbSession = new SessionBean();
			Users realUser = dbSession.getUserByEmail(email);
			if (realUser!=null){
				if (realUser.getPassword().equals(password))
					return realUser;
			}
			return null;
				
		}
		
	public String execute()
	   {
	      /* Copy file to a safe location */
	      destPath = "D:/Work/hello/src/main/webapp/metronic/assets/frontend/layout/img/media";

	      try{
	     	 System.out.println("Src File name: " + myFile);
	     	 System.out.println("Dst File name: " + myFileFileName);
	     	    	 
	     	 if(myFileFileName==null || myFileFileName.equals("")){
	     		 return ERROR;
	     	 }
	     	 
	     	 File destFile  = new File(destPath, myFileFileName);	 
	    	 FileUtils.copyFile(myFile, destFile);
	     	    	 
	    	 Users e=(Users)ActionContext.getContext().getSession().get("user");
		    	if(e==null){  		
		    		return ERROR;
		    	}
		    	 
	    	 SessionBean s = new SessionBean();
	    	 e.setPhotoPath(myFileFileName);
	    	 System.out.println(e.getEmail());
	    	 s.updateUser(e);
	    	
	    	 
	    	 
	    	 String role=e.getRole();
	    	 if(role.equals("instructor"))
	    		 return "instructor";
	    	 else
	    		 return "student";
	    	
	    	 
	    	 
	  
	      }catch(IOException e){
	         return ERROR;
	      }
	      
	      
	     
	     
	   }

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
