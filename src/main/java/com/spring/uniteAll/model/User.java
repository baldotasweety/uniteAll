package com.spring.uniteAll.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "user")
@Component
public class User {
	@Id
	@Email
	@Column(name="email")
	public String email;
	@NotNull
	public String username;
	@NotNull
	@Size(min= 3, max = 8, message="Password should not be empty.")
	public String password;
	@NotNull
	public Date birthday;
	@NotNull
	public String address;
	@NotNull
	public String role;
	@NotNull
	public Boolean enable;
	@NotNull
	public double mob_num;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public double getMob_num() {
		return mob_num;
	}
	public void setMob_num(double mob_num) {
		this.mob_num = mob_num;
	}
	
	
	

}
