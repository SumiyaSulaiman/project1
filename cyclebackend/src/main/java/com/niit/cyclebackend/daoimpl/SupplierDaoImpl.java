package com.niit.cyclebackend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.cyclebackend.dao.SupplierDao;
import com.niit.cyclebackend.model.Category;
import com.niit.cyclebackend.model.Supplier;

@Repository("SupplierDao")
public class SupplierDaoImpl implements SupplierDao {
	
	public SupplierDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupplierDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Autowired
	SessionFactory sf;

	public void saveSupplier(Supplier s) {
		
		Session s1=sf.openSession();
		s1.beginTransaction();
		s1.save(s);
		s1.getTransaction().commit();
		s1.close();
	}

	public void updateSupplier(Supplier s) {
		Session s1=sf.openSession();
		s1.beginTransaction();
		s1.update(s);
		s1.getTransaction().commit();
		s1.close();
		
	}

	public void deletSupplier(Supplier s) {
		Session s1=sf.openSession();
		s1.beginTransaction();
		s1.delete(s);
		s1.getTransaction().commit();
		s1.close();
	}

	public List<Supplier> getSuppliers() {
		
		Session s=sf.openSession();
		List<Supplier> slist=s.createQuery("from Supplier").list();
		return slist;
		
		
	}

	public Supplier getSupplier(int supId) {
		
		Session s=sf.openSession();
		s.beginTransaction();
		Supplier s1=(Supplier)s.get(Supplier.class, supId);
		s.getTransaction().commit();
		s.close();
		return s1;
		
	}
	

}
