package org.tutor.struts2.ormhelper;

import java.util.List;

import org.hibernate.Session;
import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Instructor;

public class InstructorDAO extends SessionBean
		implements OnlineTutorDAOInterface<Instructor, String>{

	public InstructorDAO() {
	}

	public void persist(Instructor entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().persist(entity);
		closeCurrentSessionWithTransaction();
	}

	public void save(Instructor entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().save(entity);
		closeCurrentSessionWithTransaction();
	}

	public void update(Instructor entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().update(entity);
		closeCurrentSessionWithTransaction();
	}

	public Instructor findById(String id) {
		openCurrentSessionWithTransaction();
		Instructor ins = (Instructor)getCurrentSession().get(Instructor.class, id);
		closeCurrentSessionWithTransaction();
		return ins;
	}

	public void delete(Instructor entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().delete(entity);
		closeCurrentSessionWithTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<Instructor> findAll() {
		openCurrentSession();
		List<Instructor> instructors = (List<Instructor>) getCurrentSession().createQuery("from Instructor").list();
		closeCurrentSession();
		return instructors;
	}

	public void deleteAll() {
		openCurrentSessionWithTransaction();
		List<Instructor> instructors = findAll();
		for (Instructor entity : instructors)
			delete(entity);
		closeCurrentSessionWithTransaction();
	}
	
	public boolean doesInstructorExists(String email){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Instructor user = (Instructor) session.get(Instructor.class, email);
			session.close();
			System.out.println(user.getEmail());
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> getInstructedCourses(String instructorId){
		openCurrentSession();
		List<Course> courses = (List<Course>) getCurrentSession().createQuery("from Course where Instructor_ID ='"+instructorId+"'").list();
		closeCurrentSession();
		return courses;
		
	}

}
