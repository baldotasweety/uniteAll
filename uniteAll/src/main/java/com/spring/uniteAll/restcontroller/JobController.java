package com.spring.uniteAll.restcontroller;

import java.util.List;

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

import com.spring.uniteAll.Dao.JobDAO;
import com.spring.uniteAll.model.Job;

import ch.qos.logback.classic.Logger;

@RestController
public class JobController {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(JobController.class);

	@Autowired
	JobDAO jobDAO;

	@Autowired
	Job job;

	@GetMapping("/job")
	public ResponseEntity<List<Job>> getJob() {
		logger.debug("Calling method getJob");
		List<Job> list = jobDAO.list();
		if (list.isEmpty() == true) {
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Job>>(HttpStatus.OK);

	}

	@GetMapping("/job/{id}")
	public ResponseEntity<Job> getJob(@PathVariable("id") String id) {
		logger.debug("Calling method getJob with Job id "+id);
		job = jobDAO.get(id);
		if (job == null) {
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Job>(HttpStatus.OK);
	}

	@PostMapping("/job")
	public ResponseEntity<Job> createJob(@RequestBody Job job){
		logger.debug("Calling method createJob");
		if(jobDAO.get(job.getJob_id())==null)
		{
		jobDAO.saveOrUpdate(job);
		return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
		return new ResponseEntity<Job>(HttpStatus.CONFLICT);
	}
	
	@DeleteMapping("/job/{id}")
	public ResponseEntity<Job> deleteJob(@PathVariable("id") String id){
		logger.debug("Calling method deleteJob");
		if(jobDAO.get(id)!=null){
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);	
		}
		jobDAO.delete(id);
		return new ResponseEntity<Job>(HttpStatus.OK);
	}
	
	@PutMapping("/job/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable String id,@RequestBody Job job){
		logger.debug("Calling Method updateJob with id"+id);
		if(jobDAO.get(id)==null){
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
		jobDAO.saveOrUpdate(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
}
