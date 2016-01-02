package org.tutor.struts2.ormhelper;

import java.util.List;

import org.tutor.struts2.model.Comment;

public class CommentDAO extends SessionBean implements OnlineTutorDAOInterface<Comment, Integer> {

	public void persist(Comment entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().persist(entity);
		closeCurrentSessionWithTransaction();
		
	}

	public void save(Comment entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().save(entity);
		closeCurrentSessionWithTransaction();
		
	}

	public void update(Comment entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().update(entity);
		closeCurrentSessionWithTransaction();
	}

	public Comment findById(Integer id) {
		openCurrentSessionWithTransaction();
		Comment comment = (Comment)getCurrentSession().get(Comment.class, id);
		closeCurrentSessionWithTransaction();
		return comment;
	}

	public void delete(Comment entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().delete(entity);
		closeCurrentSessionWithTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<Comment> findAll() {
		openCurrentSession();
		List<Comment> comments = (List<Comment>) getCurrentSession().createQuery("from Comment").list();
		closeCurrentSession();
		return comments;
	}

	public void deleteAll() {
		openCurrentSessionWithTransaction();
		List<Comment> comments = findAll();
		for (Comment entity : comments)
			delete(entity);
		closeCurrentSessionWithTransaction();
	}

}
