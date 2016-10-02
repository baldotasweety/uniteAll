package com.spring.uniteAll;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.uniteAll.Dao.BlogDAO;
import com.spring.uniteAll.Dao.ForumDAO;
import com.spring.uniteAll.Dao.UserDAO;
import com.spring.uniteAll.model.Blog;
import com.spring.uniteAll.model.Forum;
import com.spring.uniteAll.model.User;

public class ForumTest {
	
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.uniteAll");
		context.refresh();
		
		
		ForumDAO forumDAO =(ForumDAO)context.getBean("forumDAO");
			
		 Forum forum = (Forum)context.getBean("forum");
       
		User user = (User)context.getBean("user");
		UserDAO userDAO = (UserDAO)context.getBean("userDAO");
		
		forum.setForum_id("1");
		user = userDAO.get("nitika@gmail.com");
		forum.setUser(user);
		forum.setDesc("thdjyoigfhjyk8idhjg");
		forum.setForum_title("frst");
		forum.setCreation(new Date());
		forum.setEdit(new Date());
		forum.setComment("first forum");
	   
	   
		
		
		forumDAO.saveOrUpdate(forum);
	
		
		
		
	}

}
