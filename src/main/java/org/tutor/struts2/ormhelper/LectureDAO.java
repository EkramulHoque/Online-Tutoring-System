package org.tutor.struts2.ormhelper;

import java.util.List;

import org.tutor.struts2.model.Lecture;

public class LectureDAO extends SessionBean implements OnlineTutorDAOInterface<Lecture, Integer> {

	public void persist(Lecture entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().persist(entity);
		closeCurrentSessionWithTransaction();
	}

	public void save(Lecture entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().save(entity);
		closeCurrentSessionWithTransaction();
	}

	public void update(Lecture entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().update(entity);
		closeCurrentSessionWithTransaction();
	}

	public Lecture findById(Integer id) {
		openCurrentSessionWithTransaction();
		Lecture lecture = (Lecture)getCurrentSession().get(Lecture.class, id);
		closeCurrentSessionWithTransaction();
		return lecture;
	}

	public void delete(Lecture entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().delete(entity);
		closeCurrentSessionWithTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<Lecture> findAll() {
		openCurrentSession();
		List<Lecture> lectures = (List<Lecture>) getCurrentSession().createQuery("from Lecture").list();
		closeCurrentSession();
		return lectures;
	}

	public void deleteAll() {
		openCurrentSessionWithTransaction();
		List<Lecture> lectures = findAll();
		for (Lecture entity : lectures)
			delete(entity);
		closeCurrentSessionWithTransaction();
	}

}
