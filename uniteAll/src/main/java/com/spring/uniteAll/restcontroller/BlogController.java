package com.spring.uniteAll.restcontroller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.uniteAll.Dao.BlogDAO;
import com.spring.uniteAll.model.Blog;

@RestController
public class BlogController {

	
	private static final Logger logger = 
			 (Logger)LoggerFactory.getLogger(BlogController.class);
	
	
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private Blog blog;
	
	
	@GetMapping("/blogs")
	public  ResponseEntity<List<Blog>> getBlogs(){
		
		
		logger.debug("Calling method getBlogs");
		List<Blog> list = blogDAO.list();
        if(list.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(list, HttpStatus.OK);
 
		}
	
	@GetMapping("/blog/{id}")
	public ResponseEntity<Blog> getBlog(@PathVariable("id") String id) {
		logger.debug("Calling method getBlog with  id "+id);
		blog = blogDAO.get(id);
		if(blog==null)
		{
		 return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
	@PostMapping(value = "/blog")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
		
		if(blogDAO.get(blog.getBlog_id())==null)
		{
		blogDAO.saveOrUpdate(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		}
		return new ResponseEntity<Blog>(HttpStatus.CONFLICT);
	}
	
	
	@DeleteMapping("/blog/{id}")
	public ResponseEntity<Blog> deleteBlog(@PathVariable String id){
		
		logger.debug("calling delete with id"+id);
		
		if(blogDAO.get(blog.getBlog_id())!=null)
		{
	
		return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		blogDAO.delete(id);
		return new ResponseEntity<Blog>(HttpStatus.OK);
		
						
	}
	
	
	@PutMapping("/blog/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable String id, @RequestBody Blog blog){
		
        logger.debug("calling update with id"+id);
		
		if(blogDAO.get(blog.getBlog_id())==null)
		{
	
		return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		blogDAO.saveOrUpdate(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		
	
		
	}
	
}
