package com.niit.cyclebackend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.cyclebackend.dao.CategoryDao;
import com.niit.cyclebackend.model.Category;
import com.niit.cyclebackend.model.Supplier;


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
		s.close();
		
	}

	public void updateCategory(Category c) {
		Session s=sf.openSession();
		s.beginTransaction();
		s.update(c);
		s.getTransaction().commit();
		s.close();
		
	}

	public void deleteCategory(Category c) {
		Session s=sf.openSession();
		s.beginTransaction();
		s.delete(c);
		s.getTransaction().commit();
		s.close();
		
	}

	public List<Category> getCategorys() {

		Session s=sf.openSession();
		List<Category> clist=s.createQuery("from Category").list();
		return clist;
		
	}

	public Category getCategory(int catId) {
		Session s=sf.openSession();
		s.beginTransaction();
		Category c=(Category)s.get(Category.class, catId);
		s.getTransaction().commit();
		s.close();
		return c;
	}
	
	

}
