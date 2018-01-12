package com.niit.cyclebackend.dao;

import java.util.List;

import com.niit.cyclebackend.model.Cart;

public interface CartDao {
	
	void addCart(Cart c);
	void updateCart(Cart c);
	void deleteCart(Cart c);
	Cart getCartItem(int cartitemId); 
	public Cart getCartById(int pid,String userEmail);
	List<Cart> getCartItems(String username);


}
