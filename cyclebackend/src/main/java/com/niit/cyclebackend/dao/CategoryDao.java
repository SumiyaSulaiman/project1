package com.niit.cyclebackend.dao;

import java.util.List;

import com.niit.cyclebackend.model.Category;

public interface CategoryDao {
	
	void saveCategory(Category c);
	void updateCategory(Category c);
	void deleteCategory(Category c);
	List<Category> getCategorys();
	Category getCategory(int catId);

}
