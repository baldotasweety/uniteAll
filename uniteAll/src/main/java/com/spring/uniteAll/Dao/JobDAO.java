package com.spring.uniteAll.Dao;

import java.util.List;


import com.spring.uniteAll.model.Job;

public interface JobDAO {

public List<Job> list();
	
	public void saveOrUpdate(Job job);
	
	public void delete(String id);
	
	public Job get(String id);
}
