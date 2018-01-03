package com.niit.cyclebackend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.cyclebackend.dao.ProductDao;
import com.niit.cyclebackend.model.Product;

@Repository("ProductDao")
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory sf;

	public void saveProduct(Product p) {
		
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(s);
		s.getTransaction().commit();
	}

	public ProductDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		
	}

	public void deletProdudct(Product p) {
		// TODO Auto-generated method stub
		
	}

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> retrieveProductByCat(int catId) {
		// TODO Auto-generated method stub
		return null;
	}

}
