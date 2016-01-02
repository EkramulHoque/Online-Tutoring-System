package org.tutor.struts2.ormhelper;

import java.util.List;

import org.hibernate.Session;
import org.tutor.struts2.model.UnverifiedUser;

public class UnverifiedUserDAO extends SessionBean 
	implements OnlineTutorDAOInterface<UnverifiedUser, String> {

	public void persist(UnverifiedUser entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().persist(entity);
		closeCurrentSessionWithTransaction();
		
	}

	public void save(UnverifiedUser entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().save(entity);
		closeCurrentSessionWithTransaction();
	}

	public void update(UnverifiedUser entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().update(entity);
		closeCurrentSessionWithTransaction();
		
	}

	public UnverifiedUser findById(String id) {
		openCurrentSessionWithTransaction();
		UnverifiedUser unverified = (UnverifiedUser)getCurrentSession().get(UnverifiedUser.class, id);
		closeCurrentSessionWithTransaction();
		return unverified;
	}

	public void delete(UnverifiedUser entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().delete(entity);
		closeCurrentSessionWithTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<UnverifiedUser> findAll() {
		openCurrentSession();
		List<UnverifiedUser> unverifiedUsers = (List<UnverifiedUser>) getCurrentSession()
														.createQuery("from UnverifiedUser").list();
		closeCurrentSession();
		return unverifiedUsers;
	}

	public void deleteAll() {
		openCurrentSessionWithTransaction();
		List<UnverifiedUser> unverifiedUsers = findAll();
		for (UnverifiedUser entity : unverifiedUsers)
			delete(entity);
		closeCurrentSessionWithTransaction();
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

}
