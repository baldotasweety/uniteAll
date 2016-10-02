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
	public char enable;
	@NotNull
	public Number mob_num;
	public char status;
	public char gender;
	
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
	public char getEnable() {
		return enable;
	}
	public void setEnable(char enable) {
		this.enable = enable;
	}
	public Number getMob_num() {
		return mob_num;
	}
	public void setMob_num(Number mob_num) {
		this.mob_num = mob_num;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	
	

}
