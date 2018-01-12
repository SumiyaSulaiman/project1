package com.niit.cycle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="/admin/saveCategory")
	ModelAndView savecategory(@RequestParam("catname")String catname,@RequestParam("catdescription")String catdescription)
	{
		Category c=new Category();
		
		c.setCatname(catname);
		c.setCatdescription(catdescription);
		
		
		cdao.saveCategory(c);
		ModelAndView mv=new ModelAndView("redirect:/admin") ;
		return mv;
	}
	
	@RequestMapping(value="/admin/deleteCat")
	ModelAndView deletecategory(@RequestParam("id")int catid)
	{
		Category c=cdao.getCategory(catid);
		
		cdao.deleteCategory(c);
		ModelAndView mv=new ModelAndView("redirect:/admin") ;
		return mv;
	}
	
	@RequestMapping(value="/admin/editCat")
	ModelAndView editcategory(@RequestParam("id")int catid)
	{
		Category c=cdao.getCategory(catid);
							
		
		ModelAndView mv=new ModelAndView("editcategory") ;
		
		mv.addObject("c", c);
		return mv;
	}
	@RequestMapping(value="/admin/updateCategory")
	ModelAndView upcategory(@RequestParam("id")int id,@RequestParam("catname")String catname,@RequestParam("catdescription")String catdescription)
	{
		Category c=cdao.getCategory(id);
		
		c.setCatname(catname);
		c.setCatdescription(catdescription);
		
		
		cdao.updateCategory(c);
		ModelAndView mv=new ModelAndView("redirect:/admin") ;
		return mv;
	}
	
	
}
