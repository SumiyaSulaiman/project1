package com.niit.cyclebackend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.cyclebackend.dao.SupplierDao;
import com.niit.cyclebackend.model.Supplier;

@Repository("SupplierDao")
public class SupplierDaoImpl implements SupplierDao {
	
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
		// TODO Auto-generated method stub
		
	}

	public void deletSupplier(Supplier s) {
		// TODO Auto-generated method stub
		
	}

	public List<Supplier> getSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Supplier getSupplier(int supId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
