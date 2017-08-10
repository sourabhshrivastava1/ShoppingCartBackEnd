package com.niit.shoppingcart.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Mycart")
@Component
public class Mycart {
	
	private static  final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_1")
	@SequenceGenerator(name="seq_1", sequenceName="seq_1", allocationSize=1)
	private long id;
	
	
	private String product_name;
	
	private String user_id;
	
	private String price;
	
	private char status;
	
	private String quantity;
	
	private Date date_added;

	@Override
	public String toString() {
		return "MyCart [id=" + id + ", userId=" + user_id + ", price=" + price + ", name=" + product_name
				+ ", status=" + status + ", quantity=" + quantity + ", addedDate=" + date_added + "]";
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/*@OneToOne
	@JoinColumn(name = "User_id", nullable = false, updatable = false, insertable = false)*/
	//private Supplier supplier;
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	
	

}
