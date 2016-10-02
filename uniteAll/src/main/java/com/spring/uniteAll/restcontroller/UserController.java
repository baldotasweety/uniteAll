package com.spring.uniteAll.restcontroller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.uniteAll.Dao.UserDAO;
import com.spring.uniteAll.model.User;

import ch.qos.logback.classic.Logger;

public class UserController {

	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;

	@GetMapping("/user")
	public ResponseEntity<List<User>> getUser() {
		logger.debug("Calling method getUser");
		List<User> list = userDAO.list();
		if (list.isEmpty() == true) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<User>>(HttpStatus.OK);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {
		logger.debug("Calling method getUser with User id "+id);
		user = userDAO.get(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	
	

}
