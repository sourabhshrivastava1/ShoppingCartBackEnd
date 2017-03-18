package com.niit.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Product")  //if the class name and table name is different
@Component
public class Product {
   
	
	
	@Id
	private String ID;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSupplier_id() {
		return Supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		Supplier_id = supplier_id;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public void setID(String iD) {
		ID = iD;
	}
	private String name;
	private String price;
	private String Supplier_id;
	private String category_id;
	
	
	
}
