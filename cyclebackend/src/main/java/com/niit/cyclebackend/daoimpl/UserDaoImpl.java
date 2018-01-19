package com.niit.cyclebackend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.cyclebackend.dao.UserDao;
import com.niit.cyclebackend.model.Supplier;
import com.niit.cyclebackend.model.User;
@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sf;
	
	

	public UserDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void saveUser(User u) 
	{
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
		s.close();
		
		
	}

	public User getUser(String mailid) 
	{
		Session s=sf.openSession();
		s.beginTransaction();
		User s1=(User)s.get(User.class, mailid);
		s.close();
		return s1;
	}

}
