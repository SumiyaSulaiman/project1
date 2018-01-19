package com.niit.cyclebackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	
	@ManyToOne
	@JoinColumn(name="USERMAILID")
	private User user;
	
	private int cartquantity;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	
	public int getCid() {
		return cid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCartquantity() {
		return cartquantity;
	}
	public void setCartquantity(int cartquantity) {
		this.cartquantity = cartquantity;
	}
	
	
	
}
