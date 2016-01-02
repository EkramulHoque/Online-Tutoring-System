package org.tutor.struts2.ormhelper;

import java.util.List;

import org.tutor.struts2.model.Script;

public class ScriptDAO extends SessionBean implements OnlineTutorDAOInterface<Script, Integer> {

	public void persist(Script entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().persist(entity);
		closeCurrentSessionWithTransaction();
	}

	public void save(Script entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().save(entity);
		closeCurrentSessionWithTransaction();
	}

	public void update(Script entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().update(entity);
		closeCurrentSessionWithTransaction();
	}

	public Script findById(Integer id) {
		openCurrentSessionWithTransaction();
		Script script = (Script)getCurrentSession().get(Script.class, id);
		closeCurrentSessionWithTransaction();
		return script;
	}

	public void delete(Script entity) {
		openCurrentSessionWithTransaction();
		getCurrentSession().delete(entity);
		closeCurrentSessionWithTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<Script> findAll() {
		openCurrentSession();
		List<Script> allScripts = (List<Script>) getCurrentSession().createQuery("from Script").list();
		closeCurrentSession();
		return allScripts;
	}

	public void deleteAll() {
		openCurrentSessionWithTransaction();
		List<Script> allScripts = findAll();
		for (Script entity : allScripts)
			delete(entity);
		closeCurrentSessionWithTransaction();
	}

}
