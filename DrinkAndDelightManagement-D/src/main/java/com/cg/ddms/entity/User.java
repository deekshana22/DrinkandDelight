package com.cg.ddms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="user_datab")
public class User {
	@Id
	@GeneratedValue
	 private Long  userId;
	 private String userName;
	 
//	 @Pattern(regexp = "") // pattern for email validation
	 private String userEmail;
	 
//	 @Pattern(regexp = "hgfhghgh") // your pattern
	 private String userPassword;
	 
	 @NumberFormat
     private String userContact;
	 
     private String gender;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
     
}

