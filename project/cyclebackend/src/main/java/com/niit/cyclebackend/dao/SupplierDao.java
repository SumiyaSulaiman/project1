package com.niit.cyclebackend.dao;

import java.util.List;

import com.niit.cyclebackend.model.Supplier;

public interface SupplierDao {

	
	void saveSupplier(Supplier s);
	void updateSupplier(Supplier s);
	void deletSupplier(Supplier s);
	List<Supplier> getSuppliers();
	Supplier getSupplier(int supId);


}
