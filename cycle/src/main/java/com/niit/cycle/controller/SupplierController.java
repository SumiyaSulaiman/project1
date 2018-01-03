package com.niit.cycle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cyclebackend.dao.SupplierDao;
import com.niit.cyclebackend.model.Supplier;


@Controller
public class SupplierController {

	@Autowired
	SupplierDao sdao;
	
	
	@RequestMapping(value="/saveSupplier")
	ModelAndView savesupplier(@RequestParam("supname")String supname,@RequestParam("supaddress")String supaddress)
	{
		Supplier s=new Supplier();
		
		s.setSupname(supname);
		s.setSupaddress(supaddress);
		sdao.saveSupplier(s);
		List<Supplier> slist=(List<Supplier>) sdao.getSuppliers();
		System.out.println(slist);
		ModelAndView mv=new ModelAndView("redirect:/admin") ;
		return mv;
	}
}
