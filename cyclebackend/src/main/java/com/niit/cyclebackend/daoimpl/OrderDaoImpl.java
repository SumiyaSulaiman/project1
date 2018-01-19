package com.niit.cyclebackend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.cyclebackend.dao.OrderDao;
import com.niit.cyclebackend.model.Orders;

@Repository("OrderDao")
public class OrderDaoImpl implements OrderDao {

	
	@Autowired
	 SessionFactory sessionFactory;
	 
	 
	@Transactional
	public boolean addOrders(Orders order)
	{
		
		 try
	        {
	            sessionFactory.getCurrentSession().save(order);
	            return true;
	        }
	        catch(Exception e)
	        {
	            return false;
	        }
	}


	
}
