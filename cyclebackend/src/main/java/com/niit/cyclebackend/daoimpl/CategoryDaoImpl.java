package com.niit.cyclebackend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.cyclebackend.dao.CategoryDao;
import com.niit.cyclebackend.model.Category;


@Repository("CategoryDao")
public class CategoryDaoImpl implements CategoryDao {
	
	public CategoryDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Autowired
	SessionFactory sf;
	public void saveCategory(Category c) {
		
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(c);
		s.getTransaction().commit();
		
		
	}

	public void updateCategory(Category c) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCategory(Category c) {
		// TODO Auto-generated method stub
		
	}

	public List<Category> getCategorys() {
		// TODO Auto-generated method stub
		return null;
	}

	public Category getCategory(int catId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
