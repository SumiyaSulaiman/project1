package com.niit.cyclebackend.dao;

import com.niit.cyclebackend.model.User;

public interface UserDao 
{

	
void saveUser(User u);
	User getUser(String mailid);

}
