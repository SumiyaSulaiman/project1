package com.niit.cyclebackend.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table

public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productid;
	private String productname;
	private String productdescription;
	private int stock;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="C_ID")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="S_ID")
	private Supplier supplier;
	
	@OneToMany(targetEntity=Cart.class,mappedBy="product")
	private Set<Cart> cart;
	
	public int getProductid() {
		return productid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
