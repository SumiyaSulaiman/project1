package com.niit.cycle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cyclebackend.dao.SupplierDao;
import com.niit.cyclebackend.model.Category;
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
		
		ModelAndView mv=new ModelAndView("redirect:/admin") ;
		return mv;
	}
	@RequestMapping(value="/deleteSup")
	ModelAndView deletesupplier(@RequestParam("id")int supid)
	{
		Supplier s=sdao.getSupplier(supid);
		
		sdao.deletSupplier(s);
		ModelAndView mv=new ModelAndView("redirect:/admin") ;
		return mv;
	}
	
	@RequestMapping(value="/editSup")
	ModelAndView editcategory(@RequestParam("id")int supid)
	{
		Supplier s=sdao.getSupplier(supid);
							
		
		ModelAndView mv=new ModelAndView("editsupplier") ;
		mv.addObject("s", s);
		return mv;
	}
	@RequestMapping(value="/updateSupplier")
	ModelAndView upsupplier(@RequestParam("id")int id,@RequestParam("supname")String supname,@RequestParam("supaddress")String supaddress)
	{
		Supplier s=sdao.getSupplier(id);
		s.setSupname(supname);
		s.setSupaddress(supaddress);
		sdao.updateSupplier(s);
		
		ModelAndView mv=new ModelAndView("redirect:/admin") ;
		return mv;
	}
}
