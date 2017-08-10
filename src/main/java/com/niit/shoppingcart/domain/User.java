package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Columns;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="User")  //if the class name and table name is different
@Component

public class User {
	

	@Id
	private String id;
	

	@NotEmpty(message="User name should not be empty")
    private String name;
	
	@Column(  unique=true, nullable=false)
    private String Email;
	public String getEmail(){ 
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	private String contact;
	private String role;
	
	
	//@Min(5)
	//@Max(15)
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	
	
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
