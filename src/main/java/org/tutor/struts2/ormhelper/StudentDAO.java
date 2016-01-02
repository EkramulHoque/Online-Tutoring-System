package org.tutor.struts2.ormhelper;

import java.util.List;

import org.hibernate.Session;
import org.tutor.struts2.model.Student;

public class StudentDAO extends SessionBean implements OnlineTutorDAOInterface<Student, String> {
	

	public void persist(Student entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().persist(entity);
		closeCurrentSessionWithTransaction();
		
	}

	public void save(Student entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().save(entity);
		closeCurrentSessionWithTransaction();
	}

	public void update(Student entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().update(entity);
		closeCurrentSessionWithTransaction();
	}

	public Student findById(String id) {
		openCurrentSessionWithTransaction();
		Student stu = (Student)getCurrentSession().get(Student.class, id);
		closeCurrentSessionWithTransaction();
		return stu;
	}

	public void delete(Student entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().delete(entity);
		closeCurrentSessionWithTransaction();
		
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAll() {
		openCurrentSession();
		List<Student> students = (List<Student>) getCurrentSession().createQuery("from Student").list();
		closeCurrentSession();
		return students;
	}

	public void deleteAll() {
		openCurrentSessionWithTransaction();
		List<Student> students = findAll();
		for (Student entity : students)
			delete(entity);
		closeCurrentSessionWithTransaction();
	}
	
	public boolean doesStudentExists(String email){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Student user = (Student) session.get(Student.class, email);
			session.close();
			System.out.println(user.getEmail());
			return true;
		} catch (Exception e){
			return false;
		}
	
	}

}
