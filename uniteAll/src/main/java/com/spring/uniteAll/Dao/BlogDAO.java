package com.spring.uniteAll.Dao;

import java.util.List;


import com.spring.uniteAll.model.Blog;



public interface BlogDAO {
	
	public List<Blog> list();
	
	public void saveOrUpdate(Blog blog);
	
	public void delete(String id);
	
	public Blog get(String id);


}
