package org.tutor.struts2.ormhelper;

import java.util.List;

import org.tutor.struts2.model.Quiz;

public class QuizDAO extends SessionBean implements OnlineTutorDAOInterface<Quiz,Integer> {

	public void persist(Quiz entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().persist(entity);
		closeCurrentSessionWithTransaction();
	}

	public void save(Quiz entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().save(entity);
		closeCurrentSessionWithTransaction();
	}

	public void update(Quiz entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().update(entity);
		closeCurrentSessionWithTransaction();
	}

	public Quiz findById(Integer id) {
		openCurrentSessionWithTransaction();
		Quiz quiz = (Quiz)getCurrentSession().get(Quiz.class, id);
		closeCurrentSessionWithTransaction();
		return quiz;
	}

	public void delete(Quiz entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().delete(entity);
		closeCurrentSessionWithTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<Quiz> findAll() {
		openCurrentSession();
		List<Quiz> quizes = (List<Quiz>) getCurrentSession().createQuery("from Quiz").list();
		closeCurrentSession();
		return quizes;
	}

	public void deleteAll() {
		openCurrentSessionWithTransaction();
		List<Quiz> quizes = findAll();
		for (Quiz entity : quizes)
			delete(entity);
		closeCurrentSessionWithTransaction();
		
	}

}
