package com.niit.cycle.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cyclebackend.dao.CategoryDao;
import com.niit.cyclebackend.dao.ProductDao;
import com.niit.cyclebackend.dao.SupplierDao;
import com.niit.cyclebackend.model.Category;
import com.niit.cyclebackend.model.Product;
import com.niit.cyclebackend.model.Supplier;


@Controller
public class ProductController {
	
	@Autowired
	ProductDao pdao;
	@Autowired
	CategoryDao cdao;
	@Autowired
	SupplierDao sdao;
	
	@RequestMapping(value="/admin/saveProduct")
	ModelAndView saveproduct(@RequestParam("productname")String productname,@RequestParam("productdescription")String productdescription,@RequestParam("stock")int stock,@RequestParam("price")double price,@RequestParam("supid")int supid,@RequestParam("catid")int catid,@RequestParam("img") MultipartFile file)
	{
		Product p=new Product();
		
		p.setProductname(productname);
		p.setProductdescription(productdescription);
		p.setStock(stock);
		p.setPrice(price);
		p.setCategory(cdao.getCategory(catid));
		p.setSupplier(sdao.getSupplier(supid));
		pdao.saveProduct(p);
		
		String filepath="E:/project/cycle/src/main/webapp/resources/images/"+p.getProductid()+".jpg";
		
		System.out.println("------------------------------------------HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH-------------"+filepath);
		try {
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
			fos.write(imagebyte);
			fos.close();
			System.out.println("Image Saved :"+filepath);
			}catch (Exception e) {
			System.out.println("Error Occured :"+e.getMessage());
			}
		
		ModelAndView mv=new ModelAndView("redirect:/admin") ;
		return mv;
	}
	@RequestMapping(value="/productBycat")
	ModelAndView productByCat(@RequestParam("id") int catid,Model m)
	{
		
		

		m.addAttribute("clist",cdao.getCategorys());
		List<Product> plist=pdao.retrieveProductByCat(catid);
	    m.addAttribute("plist",plist);
	    
	    ModelAndView mv=new ModelAndView("productBycat") ;
		return mv;
	    
	}
	@RequestMapping(value="/admin/deleteProduct")
	ModelAndView deleteproduct(@RequestParam("id")int productid)
	{
		Product p=pdao.getProduct(productid);
		
		pdao.deletProdudct(p);
		ModelAndView mv=new ModelAndView("redirect:/admin") ;
		return mv;
	}
	
	@RequestMapping(value="/productdetails")
	public String productdetails(@RequestParam("id")int productid,@RequestParam("cmsg")String msg, Model m)
	{
		
		Product p=pdao.getProduct(productid);
		m.addAttribute("p",p);
		m.addAttribute("cmsg",msg);
		
		List<Category> cs=cdao.getCategorys();
  		m.addAttribute("clist", cs);
		return "productdetails";
		
	}
	
	
	
	@RequestMapping(value="/admin/editProduct")
	ModelAndView editproduct(@RequestParam("id")int productid)
	{
		Product p=pdao.getProduct(productid);
							
		
		ModelAndView mv=new ModelAndView("editproduct") ;
		List<Supplier> slist=sdao.getSuppliers();
		System.out.println(slist);
		mv.addObject("slist",slist);
		
		List<Category> clist=cdao.getCategorys();
		System.out.println(clist);
		mv.addObject("clist",clist);
		
		
		mv.addObject("p", p);
		return mv;
	}
	
	@RequestMapping(value="/admin/updateProduct")
	ModelAndView upproduct(@RequestParam("id")int id,@RequestParam("productname")String productname,@RequestParam("productdescription")String productdescription,@RequestParam("stock")int stock,@RequestParam("price")double price,@RequestParam("supid")int supid,@RequestParam("catid")int catid,@RequestParam("img") MultipartFile file)
	{
		Product p=pdao.getProduct(id);
		
		p.setProductname(productname);
		p.setProductdescription(productdescription);
		p.setStock(stock);
		p.setPrice(price);
		p.setCategory(cdao.getCategory(catid));
		p.setSupplier(sdao.getSupplier(supid));
		
		pdao.updateProduct(p);
		String filepath="E:/project/cycle/src/main/webapp/resources/images/"+p.getProductid()+".jpg";
		
		System.out.println("------------------------------------------HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH-------------"+filepath);
		try {
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
			fos.write(imagebyte);
			fos.close();
			System.out.println("Image Saved :"+filepath);
			}catch (Exception e) {
			System.out.println("Error Occured :"+e.getMessage());
			}
		
		ModelAndView mv=new ModelAndView("redirect:/admin") ;
		return mv;
	}
	
	 
}
