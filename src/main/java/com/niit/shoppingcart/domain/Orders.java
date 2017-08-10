package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Orders")  //if the class name and table name is different
@Component               //if want to cerate instance of Class Category  - category
public class Orders  {

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}
	private static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_1")
	@SequenceGenerator(name="seq_1", sequenceName="seq_1", allocationSize=1)
	
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column
	private String user_id;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getHouse_no() {
		return house_no;
	}
	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCard_type() {
		return Card_type;
	}
	public void setCard_type(String card_type) {
		Card_type = card_type;
	}
	public String getCard_no() {
		return Card_no;
	}
	public void setCard_no(String card_no) {
		Card_no = card_no;
	}
	public String getCard_cvv() {
		return Card_cvv;
	}
	public void setCard_cvv(String card_cvv) {
		Card_cvv = card_cvv;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	private String house_no;
	private String Street;
	private String City;
	private String Pincode;
	private String State;
	private String Country;
	private String Card_type;
	private String Card_no;
	private String Card_cvv;
	private String expirydate;
}






















