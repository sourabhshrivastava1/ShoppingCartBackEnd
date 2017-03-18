package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Category")  //if the class name and table name is different
@Component               //if want to cerate instance of Class Category  - category
public class Category {
	
	//add simple properties - same as Category table
	//generate getter/setter methods
	
	@Id
	private String id;
	
	@Column(name="name")  //if the field name and property name is different
	private String name;
	
	private String description;

	public String getId() {
		return id;
	}

	public  String setId(String id) {
		return this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
