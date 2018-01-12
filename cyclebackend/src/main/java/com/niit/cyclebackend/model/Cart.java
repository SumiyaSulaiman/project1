package com.niit.cyclebackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private int cartquantity;
	
	public int getCid() {
		return cid;
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
