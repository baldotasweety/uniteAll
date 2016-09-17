package com.spring.uniteAll.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.uniteAll.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<Blog> list() {
		
		return null;
	}

	@Transactional
	public void saveOrUpdate(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		
	}

	@Transactional
	public void delete(String title) {
		
		Blog blog = new Blog();
		blog.setBlog_title(title);
		sessionFactory.getCurrentSession().delete(blog);
		try{
			sessionFactory.getCurrentSession().delete(blog);
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
	}

	@Transactional
	public Blog getByTitle(String title) {
		String hql = "from Blog where blog_title=" + "'"+ title+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
