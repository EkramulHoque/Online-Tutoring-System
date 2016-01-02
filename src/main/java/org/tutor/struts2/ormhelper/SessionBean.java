/**
 * This is a helper class to maintain connection between db and Objects
 */
package org.tutor.struts2.ormhelper;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tutor.struts2.model.Comment;
import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Instructor;
import org.tutor.struts2.model.Lecture;
import org.tutor.struts2.model.Script;
import org.tutor.struts2.model.Student;
import org.tutor.struts2.model.UnverifiedUser;
import org.tutor.struts2.model.Users;

 
import org.hibernate.Transaction;
 


public class SessionBean {
	
	 
	

	private Session currentSession;
	private Transaction currentTransaction;
	
	

	
	//SessionFactory created only once in the whole application
	public static SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void setSessionFactory(SessionFactory sessionFactory) {
		SessionBean.sessionFactory = sessionFactory;
	}
	
	public Session openCurrentSession() {
		currentSession = SessionBean.sessionFactory.openSession();
		return currentSession;
	}

	public Session openCurrentSessionWithTransaction() {
		currentSession = SessionBean.sessionFactory.openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public boolean closeCurrentSession() {
		try {
			currentSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean closeCurrentSessionWithTransaction() {
		try {
			currentTransaction.commit();
			currentSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	 
	
	///////////////My Sessions///////////////////
	public boolean saveUser(Users u){
		Session session=null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public void clear(){
		try{
		sessionFactory.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	/**
	 * Used for getting Users instance form database for email primatry key
	 * @param email primary key to search for the object
	 * @return user object if found one else null if no entry is found against
	 * the provided email
	 */
	public Users getUserByEmail(String email){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Users user = (Users) session.get(Users.class, email);
			session.close();
			return user;
		} catch (Exception e){
			return null;
		}
	}
	
	public boolean doesUserExists(String email){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Users user = (Users) session.get(Users.class, email);
			session.close();
			System.out.println(user.getEmail());
			return true;
		} catch (Exception e){
			return false;
		}
	
	}
	public boolean doesUnverifiedUserExists(String email){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			UnverifiedUser user = (UnverifiedUser) session.get(UnverifiedUser.class, email);
			session.close();
			System.out.println(user.getEmail());
			return true;
		} catch (Exception e){
			return false;
		}
	
	}
	
	public Lecture getLecture(int id){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Lecture lecture= (Lecture) session.get(Lecture.class, id);
			session.close();
			return lecture;
		} catch (Exception e){
			return null;
		}
	}
	
	public boolean updateLecture(Lecture l){
		Session session=null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(l);
			session.getTransaction().commit();
			session.close();
			System.out.println("Lecture Updated---------------------------");
			return true;
		} catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}
	

	public boolean saveComment(Comment s){
		Session session=null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public Student getStudent(String email){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Student student= (Student) session.get(Student.class, email);
			session.close();
			return student;
		} catch (Exception e){
			return null;
		}
	}
	
	public Instructor getInstructor(String email){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Instructor instructor= (Instructor) session.get(Instructor.class, email);
			session.close();
			return instructor;
		} catch (Exception e){
			return null;
		}
	}
	
	public List<Course> findByInstructor(String email) {
		Session session = null;
		try{
			session = sessionFactory.openSession();
			List<Course> courses = (List<Course>) session.createQuery("from Course where Instructor_ID ='"+email+"'").list();
			session.close();
			return courses;
			}catch (Exception e){
				return null;
			}
	}
	
	public List<Comment> findCommentByLectureId(int id){
		Session session=null;
		try{
			
			session=sessionFactory.openSession();
			List<Comment> comment=(List<Comment>)session.createQuery("from Comment where lectureID ='"+id+"'").list();
			session.close();
			return comment;
		}catch(Exception e)
		{
			
			return null;
		}	
	}
	
	
	
	public boolean saveScript(Script s){
		Session session=null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
 	public boolean updateUser(Users u){
		Session session=null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(u);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	} 
	
	public boolean updateStudent(Student u){
		Session session=null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(u);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean updateInstructor(Instructor u){
		Session session=null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(u);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	////////////////My session Ends//////////////////////////
	
	public Course getCourse(String courseID) {
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Course course= (Course) session.get(Course.class, courseID);
			session.close();
			return course;
		} catch (Exception e){
			return null;
		}
	}

	public List<Lecture> findByCourse(String courseID) {
		Session session = null;
		try{
			session = sessionFactory.openSession();
			List<Lecture> lectures = (List<Lecture>) session.createQuery("from Lecture where Course_ID ='"+courseID+"'").list();
			session.close();
			return lectures;
			}catch (Exception e){
				return null;
			}
	}

	public boolean saveCourse(Course newCourse) {
		Session session=null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(newCourse);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
		
	}

	public List<Course> findByStudent(String email) {
		Session session = null;
		try{
			session = sessionFactory.openSession();
			List<Course> courses = (List<Course>) session.createQuery("from Course cor join fetch cor.students where Student_ID = '"+email+"'").list();
			session.close();
			return courses;
			}catch (Exception e){
				return null;
			}
	}

	public List<Course> findOtherCoursesByStudent(String email) {
		Session session = null;
		try{
			session = sessionFactory.openSession();
			//List<Course> courses = (List<Course>) session.createQuery("from Course cor left outer join fetch cor.students where Student_ID is not '"+email+"'").list();
			List<Course> courses = (List<Course>) session.createQuery("from Course").list();
			session.close();
			return courses;
			}catch (Exception e){
				return null;
			}
	}
	
	public List<Lecture> getLecturesByCourse(String courseID) {
		Session session = null;
		try{
			session = sessionFactory.openSession();
			List<Lecture> lectures = (List<Lecture>) session.createQuery("from Lecture where Course_ID='"+courseID+"'").list();
			session.close();
			return lectures;
			}catch (Exception e){
				return null;
			}
	}

	public boolean updateCourse(Course course) {
		Session session=null;
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(course);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
		
	}
	public boolean saveLecture(Lecture newLecture) {
		  Session session=null;
		  try{
		   session = sessionFactory.openSession();
		   session.beginTransaction();
		   session.save(newLecture);
		   session.getTransaction().commit();
		   session.close();
		   return true;
		  } catch(Exception e){
		   session.getTransaction().rollback();
		   return false;
		  }
		 }


	 

	 
	 

	 

	 
	 

	 
	 

}
