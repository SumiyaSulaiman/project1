package com.niit.cycle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cyclebackend.dao.CartDao;
import com.niit.cyclebackend.dao.CategoryDao;
import com.niit.cyclebackend.dao.OrderDao;
import com.niit.cyclebackend.dao.ProductDao;
import com.niit.cyclebackend.dao.UserDao;
import com.niit.cyclebackend.model.Cart;
import com.niit.cyclebackend.model.Category;
import com.niit.cyclebackend.model.Orders;
import com.niit.cyclebackend.model.Product;
import com.niit.cyclebackend.model.User;

@Controller
public class CartController {
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CategoryDao cdao;
	
	@Autowired
	UserDao udao;
	
	@Autowired
	OrderDao odao;
	
	@Autowired
	CartDao cartdao;
	
	
	@RequestMapping(value="/user/cart")
  	public String cart(Model m,@RequestParam("cmsg")String msg)
  	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  		String name = authentication.getName();	
  		
  		List<Category> cs=cdao.getCategorys();
  		m.addAttribute("clist", cs);
  		
  		List<Cart> calist=cartdao.getCartItems(name);
  		m.addAttribute("calist",calist);
  		m.addAttribute("cmsg",msg);
  		return "shoppingcart";
  	}
	
	@RequestMapping(value="/user/saveOrder")
	ModelAndView saveorder(@RequestParam("total")double gtot,@RequestParam("email")String email,@RequestParam("name")String name,@RequestParam("address")String address,@RequestParam("phone")String contactno,@RequestParam("city")String city,@RequestParam("country")String country,@RequestParam("state")String state,@RequestParam("postalcode")String pincode)
	{
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		ModelAndView mv=new ModelAndView("invoice") ;
		User u=udao.getUser(username);
		mv.addObject("User",u);
		
		Orders o=new Orders();
		
		o.setName(name);
		o.setAddress(address);
		o.setPhone(contactno);
		o.setEmail(email);
		o.setCity(city);
		o.setState(state);
		o.setCountry(country);
		o.setPincode(pincode);
		o.setGranttotal(gtot);
		o.setUser(u);
		odao.addOrders(o);
		
		
		 List<Cart> cartList=cartdao.getCartItems(username);
		    mv.addObject("Cart", cartList);
		
		return mv;
		
	}
	
	@RequestMapping(value="/user/addcart")
  	public String addcart(@RequestParam("productid")int productid, @RequestParam("qty")int qty,Model m)
  	{
  		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  		String name = auth.getName();		
  		

		
		
		Product p=pdao.getProduct(productid);
		
		
		if(p.getStock()>=qty)
  		{
  		
  		Cart c1=cartdao.getCartById(productid, name);
  		if(c1==null)
  		{
	  		Cart c=new Cart();
	  		c.setCartquantity(qty);
	  		c.setProduct(p);
	  		c.setUser(udao.getUser(name));
	  		cartdao.addCart(c);
	  		p.setStock(p.getStock()-qty);
	  		pdao.updateProduct(p);
	  		m.addAttribute("cmsg","Product added to cart");
  		}
  		else
  		{	
  			
  			c1.setCartquantity(c1.getCartquantity()+qty);
  			cartdao.updateCart(c1);
  			p.setStock(p.getStock()-qty);
	  		pdao.updateProduct(p);
  			m.addAttribute("cmsg","cart updated successfully");
  		}
  		
  		
  		return "redirect:/user/cart";
  		}
  		
  		else
  		{
  				if(p.getStock()==0)
  				{
  					m.addAttribute("cmsg","NO STOCK AVAILABLE");
  				}
  				else
  				{
  					m.addAttribute("cmsg","Required quantity not available");
  				}
  				return "redirect:/productdetails?id="+productid;
  		}
  	}
		@RequestMapping(value="/user/deleteCart")
		public String deleteCart(@RequestParam("id")int cartId,Model m)
	    {
	        Cart cart=cartdao.getCartItem(cartId);
	        Product p1=cart.getProduct();
	        p1.setStock(p1.getStock()+cart.getCartquantity());
	        pdao.updateProduct(p1);
	     
	        
	        cartdao.deleteCart(cart);
	        Cart cartList=cartdao.getCartItem(cartId);
	        m.addAttribute("calist",cartList);
	         
	        Cart cart1=new Cart();
	        m.addAttribute(cart1);
	        m.addAttribute("cmsg","Cart item deleted Successfully");
	         
	        return "redirect:/user/cart";
	    }
		
		@RequestMapping(value="/user/updateCart")
	    public String updateCart(@RequestParam("pid") int productid,@RequestParam("id") int cartId,@RequestParam("qty") int qty,Model m)
	    {
			Cart c=cartdao.getCartItem(cartId);
			Product p=pdao.getProduct(productid);
			
			if(c.getProduct().getStock()>=qty)
			{
				int cq=c.getCartquantity();
				c.setCartquantity(qty);
				cartdao.updateCart(c);
				m.addAttribute("cmsg", "");
				
				if(cq-qty<=0)
				{
					int q=qty-cq;
					p.setStock(p.getStock()-q);
			  		pdao.updateProduct(p);
				}
				else
				{
					int q=cq-qty;
					p.setStock(p.getStock()+q);
			  		pdao.updateProduct(p);
				}
			}
			else
			{
				m.addAttribute("cmsg", "Not in Stock");
			}
			
			return "redirect:/user/cart";
	    }
		@RequestMapping("/user/checkout")
		String checkout(Model m)
		{
			
			
	  		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			

			List<Category> cs=cdao.getCategorys();
	  		m.addAttribute("clist", cs);
			
			
			List<Cart> cartList=cartdao.getCartItems(username);
		    m.addAttribute("Cart", cartList);
		    User u=udao.getUser(username);
			m.addAttribute("u",u);
			
			return "checkout";
		}
		
		@RequestMapping("/user/thankyou")
		String thankyou(Model m)
		{
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			
			List<Category> cs=cdao.getCategorys();
	  		m.addAttribute("clist", cs);
			
			List<Cart> cartList=cartdao.getCartItems(username);
			
			for(Cart c:cartList)
			{
				cartdao.deleteCart(c);
			}
			return "thankyou";
		}
		
		
		
  		
  	   
		
  	   
		
  	
}