package com.niit.cyclebackend.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int catid;
	private String catname;
	private String catdescription;
	
	@OneToMany(targetEntity=Product.class,mappedBy="category")
	private Set<Product> product;
	
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	
	
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getCatdescription() {
		return catdescription;
	}
	public void setCatdescription(String catdescription) {
		this.catdescription = catdescription;
	}
	

	
	
}
	

	

