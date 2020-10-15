package com.cg.ddms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ddms.dao.UserDao;
import com.cg.ddms.entity.Admin;
import com.cg.ddms.entity.User;


@Service

public class UserServiceImpl implements UserService {
	@Autowired //autowiring admin repository.
	UserDao userDao;
	/**
	 * Mapping for logging in as user.
	 */
	
	@Override
	public User loginUser(String userEmail, String userPassword) {
   User user = userDao.findByUserEmail(userEmail);

	try {
		 if(user.getUserPassword().equals(userPassword.toString())) {
			System.out.println("------------- password match----------------");
		}
	} catch (NullPointerException ex){
		System.out.println("------------------------ user not found with id: " + userEmail + "----------------------");
		user = null;
	}
    
		return user;
	}
		
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	
}
