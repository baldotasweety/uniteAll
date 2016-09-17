package com.spring.uniteAll.Dao;

import java.util.List;

import com.spring.uniteAll.model.Forum;

public interface ForumDAO {

public List<Forum> list();
	
	public void saveOrUpdate(Forum forum);
	
	public void delete(String title);
	
	public Forum getByTitle(String title);


}
