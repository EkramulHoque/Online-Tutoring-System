package org.tutor.struts2.ormhelper;

import java.util.List;

import org.tutor.struts2.model.Course;

public class CourseDAO extends SessionBean implements OnlineTutorDAOInterface<Course, String> {

	public void persist(Course entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().persist(entity);
		closeCurrentSessionWithTransaction();
	}

	public void save(Course entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().save(entity);
		closeCurrentSessionWithTransaction();
	}

	public void update(Course entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().update(entity);
		closeCurrentSessionWithTransaction();
	}

	public Course findById(String id) {
		openCurrentSessionWithTransaction();
		Course course = (Course)getCurrentSession().get(Course.class, id);
		closeCurrentSessionWithTransaction();
		return course;
	}

	public void delete(Course entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().delete(entity);
		closeCurrentSessionWithTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<Course> findAll() {
		openCurrentSession();
		List<Course> courses = (List<Course>) getCurrentSession().createQuery("from Course").list();
		closeCurrentSession();
		return courses;
	}

	public void deleteAll() {
		openCurrentSessionWithTransaction();
		List<Course> courses = findAll();
		for (Course entity : courses)
			delete(entity);
		closeCurrentSessionWithTransaction();
	}

}
