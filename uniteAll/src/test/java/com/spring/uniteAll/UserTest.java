package com.spring.uniteAll;

import java.util.Date;

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
		user.setBirthday( new Date());
		user.setEnable('t');
		user.setRole("user");
		user.setAddress("daund");
		
		
	   
	   
		
		
		userDAO.saveOrUpdate(user);
	
		
		
		
	}

}
