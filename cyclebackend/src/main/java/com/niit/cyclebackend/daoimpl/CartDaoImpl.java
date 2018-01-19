package com.niit.cyclebackend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.cyclebackend.dao.CartDao;
import com.niit.cyclebackend.model.Cart;

@Repository
@EnableTransactionManagement
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionF;
	
	

	public CartDaoImpl() {
		super();
		
	}


	public CartDaoImpl(SessionFactory sessionF) {
		super();
		this.sessionF = sessionF;
	}

	
	public void addCart(Cart c) {
		
		Session session=sessionF.openSession();
		session.beginTransaction();
		session.persist(c);
		session.getTransaction().commit();	
		
	}

	public void updateCart(Cart c) {
		Session session=sessionF.openSession();
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();
		
	}

	public void deleteCart(Cart c) {
		Session session=sessionF.openSession();
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
	}

	public Cart getCartItem(int cartitemId) {
		Session session=sessionF.openSession();
        Cart cart=(Cart)session.get(Cart.class, cartitemId);
        session.close();
        return cart;
		
	}

	public Cart getCartById(int pid, String mail) {
		Session session=sessionF.openSession();
		Cart cr=null;
		try
		{
			System.out.println("===========Product existence============="+cr);
			session.beginTransaction();
			cr=(Cart)session.createQuery("From Cart where USERMAILID =:mail and PRODUCT_ID=:id")
					        .setString("mail",mail)
					        .setInteger("id", pid)
					        .uniqueResult();
			session.getTransaction().commit();
			System.out.println("Cart: "+cr);
			return cr;
		}
		catch(HibernateException e)
		{
			System.out.println("===========ERROR============="+e.getMessage());
			session.getTransaction().rollback();
		}
		return cr;
	}
	


	public List<Cart> getCartItems(String username) {
		
		Session session=sessionF.openSession();
        List<Cart> cr=null;
        try
        {
            session.beginTransaction();
             
            cr=(List<Cart>)session.createQuery("From Cart where USERMAILID='"+username+"'").list();
            session.getTransaction().commit();
        }
        catch(HibernateException e)
        {
            session.getTransaction().rollback();
        }
        return cr;
}	
	}


