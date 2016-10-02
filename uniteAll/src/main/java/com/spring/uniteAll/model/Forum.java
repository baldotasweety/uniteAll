package com.spring.uniteAll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "forum")
@Component
public class Forum {
	
	@Id
	public String forum_id;
	@ManyToOne
	@JoinColumn(name="email")
	private User user;
	public Date creation;
	public Date edit;
	public String forum_title;
	public String desc;
	public String comment;
	public String getForum_id() {
		return forum_id;
	}
	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public Date getEdit() {
		return edit;
	}
	public void setEdit(Date edit) {
		this.edit = edit;
	}
	public String getForum_title() {
		return forum_title;
	}
	public void setForum_title(String forum_title) {
		this.forum_title = forum_title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
