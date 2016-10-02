package com.spring.uniteAll.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.spring.uniteAll.model.Job;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<Job> list() {
		
		return null;
	}

	@Transactional
	public void saveOrUpdate(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		
	}

	@Transactional
	public void delete(String id) {
		
		Job job = new Job();
		job.setJob_id(id);
		sessionFactory.getCurrentSession().delete(job);
		try{
			sessionFactory.getCurrentSession().delete(job);
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
	}

	@Transactional
	public Job get(String id) {
		String hql = "from Blog where job_id=" + "'"+ id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Job> list = (List<Job>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}


}
