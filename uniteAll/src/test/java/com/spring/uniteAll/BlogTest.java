package com.spring.uniteAll;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.uniteAll.Dao.BlogDAO;
import com.spring.uniteAll.Dao.UserDAO;
import com.spring.uniteAll.model.Blog;
import com.spring.uniteAll.model.User;

public class BlogTest {

	
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.uniteAll");
		context.refresh();
		
		
		BlogDAO blogDAO =(BlogDAO)context.getBean("blogDAO");
			
		Blog blog = (Blog)context.getBean("blog");
       
		User user = (User)context.getBean("user");
		UserDAO userDAO = (UserDAO)context.getBean("userDAO");
		
		blog.setBlog_id("BL101");
		user = userDAO.get("nitika@gmail.com");
		blog.setUser(user);
		blog.setBlog_title("first");
		blog.setDescription("abcdefgvejkfelo");
		
	   
	   
		
		
		blogDAO.saveOrUpdate(blog);
	
		
		
		
	}

}
