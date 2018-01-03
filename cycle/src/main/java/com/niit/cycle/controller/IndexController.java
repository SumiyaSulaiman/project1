package com.niit.cycle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	String index(Model m)
	{
		
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
	

	@RequestMapping("/kids")
	String kids(Model m)
	{
		
		return "kids";
	}
	
	@RequestMapping("/women")
	String women(Model m)
	{
		
		return "women";
	}
	
	
	@RequestMapping("/admin")
	String admin(Model m)
	{
		
		return "admin";
	}
	
	
	
}
