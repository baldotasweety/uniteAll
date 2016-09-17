package com.spring.uniteAll;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.uniteAll.Dao.UserDAO;
import com.spring.uniteAll.model.User;



public class UserTest {
	
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.uniteAll");
		context.refresh();
		
		
		UserDAO userDAO = (UserDAO)context.getBean("userDAO");
			
		User user = (User)context.getBean("user");
       
		
		
		user.setUsername("nitika");
		user.setPassword("nitu");
		user.setEmail("nitika@gmail.com");
		user.setMob_num(992183211);
		//user.setBirthday();
		user.setEnable(true);
		user.setRole("user");
		user.setAddress("daund");
		
		
	   
	   
		
		
		userDAO.saveOrUpdate(user);
	
		
		
		
	}

}
