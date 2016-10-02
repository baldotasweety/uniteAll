package com.spring.uniteAll.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "job")
@Component
public class Job {
	
	@Id
	public String job_id;
	@ManyToOne
	@JoinColumn(name="email")
	private User user;
	public String job_desc;
	public String req;
	public Date creation;
	public String comp_name;
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getJob_desc() {
		return job_desc;
	}
	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}
	public String getReq() {
		return req;
	}
	public void setReq(String req) {
		this.req = req;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	
	
	
	
}
