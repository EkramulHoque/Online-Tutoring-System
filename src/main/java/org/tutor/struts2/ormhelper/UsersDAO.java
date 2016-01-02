package org.tutor.struts2.ormhelper;

import java.util.List;

import org.hibernate.Session;
import org.tutor.struts2.model.Users;

public class UsersDAO extends SessionBean implements OnlineTutorDAOInterface<Users, String> {

	public void persist(Users entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().persist(entity);
		closeCurrentSessionWithTransaction();
	}

	public void save(Users entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().save(entity);
		closeCurrentSessionWithTransaction();
	}

	public void update(Users entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().update(entity);
		closeCurrentSessionWithTransaction();
	}

	public Users findById(String id) {
		openCurrentSessionWithTransaction();
		Users user = (Users)getCurrentSession().get(Users.class, id);
		closeCurrentSessionWithTransaction();
		return user;
	}

	public void delete(Users entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().delete(entity);
		closeCurrentSessionWithTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<Users> findAll() {
		openCurrentSession();
		List<Users> users = (List<Users>) getCurrentSession()
														.createQuery("from Users").list();
		closeCurrentSession();
		return users;
	}

	public void deleteAll() {
		openCurrentSessionWithTransaction();
		List<Users> users = findAll();
		for (Users entity : users)
			delete(entity);
		closeCurrentSessionWithTransaction();
		
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

}
