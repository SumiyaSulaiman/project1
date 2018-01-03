package com.niit.cycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cyclebackend.dao.CategoryDao;
import com.niit.cyclebackend.dao.UserDao;
import com.niit.cyclebackend.model.Category;
import com.niit.cyclebackend.model.User;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDao cdao;
	
	@RequestMapping(value="/saveCategory")
	ModelAndView savecategory(@RequestParam("catname")String catname,@RequestParam("catdescription")String catdescription)
	{
		Category c=new Category();
		
		c.setCatname(catname);
		c.setCatdescription(catdescription);
		
		
		cdao.saveCategory(c);
		ModelAndView mv=new ModelAndView("redirect:/admin") ;
		return mv;
	}

}
