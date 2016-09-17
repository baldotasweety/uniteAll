package com.spring.uniteAll.Dao;

import java.util.List;

import com.spring.uniteAll.model.User;


public interface UserDAO {

	
	public List<User> list();
	public void saveOrUpdate(User user);
	
	public User getByName(String name);
	public void delete(String email);
	public User get(String email);
	public boolean isValid(String username, String password);
	
}
