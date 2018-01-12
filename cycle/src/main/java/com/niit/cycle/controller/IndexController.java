package com.niit.cycle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cyclebackend.dao.CategoryDao;
import com.niit.cyclebackend.dao.ProductDao;
import com.niit.cyclebackend.dao.SupplierDao;
import com.niit.cyclebackend.model.Category;
import com.niit.cyclebackend.model.Product;
import com.niit.cyclebackend.model.Supplier;

@Controller
public class IndexController {

	@Autowired
	SupplierDao sdao;
	@Autowired
	CategoryDao cdao;
	@Autowired
	ProductDao pdao;
	
	@RequestMapping("/")
	String index(Model m)
	{
		List<Category> clist=cdao.getCategorys();
		System.out.println(clist);
		m.addAttribute("clist",clist);
		
		return "index";
	}
	
	@RequestMapping("/register")
	String register(Model m) 
	{
		
		return "registration";
	}

	
	@RequestMapping("/Login")
	String Login(Model m)
	{
		
		return "login";
	}
	
	
	
	
	@RequestMapping("/admin")
	String admin(Model m)
	{
		List<Supplier> slist=sdao.getSuppliers();
		System.out.println(slist);
		m.addAttribute("slist",slist);
		
		List<Category> clist=cdao.getCategorys();
		System.out.println(clist);
		m.addAttribute("clist",clist);
		
		

		List<Product> plist=pdao.getProducts();
		System.out.println(plist);
		m.addAttribute("plist",plist);
		return "admin";
		
	}
	
	
	
}
