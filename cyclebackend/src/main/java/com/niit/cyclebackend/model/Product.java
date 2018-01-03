package com.niit.cyclebackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table

public class Product {
	
	@Id
	private int productid;
	private String productname;
	private String productdesription;
	private int quantity;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="C_ID")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="S_ID")
	private Supplier supplier;
	
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
	public String getProductdesription() {
		return productdesription;
	}
	public void setProductdesription(String productdesription) {
		this.productdesription = productdesription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
