package com.spring.uniteAll.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.uniteAll.model.Forum;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Forum> list() {
		// TODO Auto-generated method stub
		return null;
	}
    
	@Transactional
	public void saveOrUpdate(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		
	}
	@Transactional
	public void delete(String title) {
		Forum forum = new Forum();
		forum.setForum_title(title);
		sessionFactory.getCurrentSession().delete(forum);
		try{
			sessionFactory.getCurrentSession().delete(forum);
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
	}
   
	@Transactional
	public Forum getByTitle(String title) {
		String hql = "from Forum where forum_title=" + "'"+ title+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}

}
