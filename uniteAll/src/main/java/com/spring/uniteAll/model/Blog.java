package com.spring.uniteAll.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "blog")
@Component
public class Blog {
    @Id
	public String blog_id;
	@ManyToOne
	@JoinColumn(name="email")
	private User user;
	@NotNull
	public String description;
	public char status;
	@NotNull
	public String blog_title;
	public String getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public char isStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getBlog_title() {
		return blog_title;
	}
	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}
	
}
