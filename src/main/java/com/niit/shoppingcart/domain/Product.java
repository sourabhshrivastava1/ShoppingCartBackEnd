/*package com.niit.shoppingcart.domain;

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
	
	
	
}*/

package com.niit.shoppingcart.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Products")
@Component
public class Product implements Serializable {
	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ID;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	@Column(name="description")  //if the name of field in db
				// and property name in Domain object is different
	private String description;
	private String name;
	private String price;
	@Transient
	private MultipartFile File;
	public MultipartFile getFile() {
		return File;
	}

	public void setFile(MultipartFile file) {
		File = file;
	}

	private String category_id;  ///1
	

	private String supplier_id;

	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "category_id", updatable = false, insertable = false, nullable = false)
	private Category category;

	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "supplier_id", nullable = false, updatable = false, insertable = false)
	private Supplier supplier;

	//Will not persist in database
	/*@Transient
	private MultipartFile image;
	

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}*/

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getID() {
		return ID;
	}

	public void setID(long id) {
		this.ID =ID;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String string) {
		this.price = string;
	}

	public String getStock() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStock(String string) {
		// TODO Auto-generated method stub
		
	}

	/*  @OneToMany(mappedBy="product",fetch = FetchType.EAGER)	
	  	private Set<Mycart> Mycart;
	public Set<Mycart> getMycarts() {
		return Mycart;
	}
	public void setMycart(Set<Mycart> mycart) {
		Mycart = mycart;*/
	}



/*package com.niit.shoppingcart.domain;



import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")  //if the class name and table name is different
@Component
public class Product {
   
	
	
	
	@Id
	private static String ID;
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
	
	
	
	@Column(name="name")
	private String name;
	private String price;
	@Transient
	private MultipartFile File;

	@ManyToOne
	@JoinColumn(name = "category_id", updatable = false, insertable = false, nullable = false)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable = false, updatable = false, insertable = false)
	private Supplier supplier;
	private String Supplier_id;
	private String category_id;
	private String description;
	
	

	public void setFile(MultipartFile file) {
		this.File = file;
	}
	
	public static String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setId(String id) {
		this.ID = id;
	}
	
	public static String getID() {
		return ID;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	public MultipartFile getFile() {
		// TODO Auto-generated method stub
  return this.File;
	}
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
	public List getAllProducts() {
		// TODO Auto-generated method stub
		return getAllProducts();
	}
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}
	
	  @OneToMany(mappedBy="product",fetch = FetchType.EAGER)	
	  	private Set<MyCart> Mycarts;
	public Set<MyCart> getMycarts() {
		return Mycarts;
	}
	public void setMycarts(Set<MyCart> mycarts) {
		Mycarts = mycarts;
	}

	 
	
}

package com.niit.shoppingcart.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Product")
@Component
public class Product  implements Serializable{
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private static String id;
	private String name;
	@Column(name="description")  //if the name of field in db
				// and property name in Domain object is different
	private byte[] description;
	private String price;
	
	private String category_id;  ///1
	

	private String supplier_id;

	@ManyToOne
	@JoinColumn(name = "category_id", updatable = false, insertable = false, nullable = false)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable = false, updatable = false, insertable = false)
	private Supplier supplier;

	//Will not persist in database
	@Transient
	private MultipartFile file;
	

	public MultipartFile getImage() {
		return file;
	}

	public void setImage(MultipartFile string) {
		this.file = string;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static String getId() {
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

	public byte[] getDescription() {
		return description;
	}

	public void setDescription(byte[] bs) {
		this.description = bs;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String string) {
		this.price = string;
	}

	public void setImage(String string) {
		// TODO Auto-generated method stub
		
	}

}

*/