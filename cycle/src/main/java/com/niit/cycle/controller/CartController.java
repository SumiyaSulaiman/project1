package com.niit.cycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cyclebackend.dao.ProductDao;
import com.niit.cyclebackend.model.Product;

@Controller
public class CartController {
	
	@Autowired
	ProductDao pdao;
	
	
	@RequestMapping(value="/shoppingcart")
  	public ModelAndView goToaddCart(@RequestParam("productid")int productid, @RequestParam("qty")int qty)
  	{
  		
		Product p=pdao.getProduct(productid);
  		ModelAndView mv=new ModelAndView("redirect:/shoppingcart") ;
		return mv;
  	}
}
