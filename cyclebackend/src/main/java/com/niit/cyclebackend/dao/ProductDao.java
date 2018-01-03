package com.niit.cyclebackend.dao;

import java.util.List;

import com.niit.cyclebackend.model.Product;

public interface ProductDao {

	void saveProduct(Product p);
		void updateProduct(Product p);
		void deletProdudct(Product p);
		List<Product> getProducts();
		Product getProduct(int id);
		List<Product> retrieveProductByCat(int catId);
		

}