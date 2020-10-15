package com.cg.ddms.service;

import com.cg.ddms.entity.User;

public interface UserService {
	public User loginUser(String userEmail, String Password);
//	public Seller getSellerById(Long id);
	public User addUser(User user);
}
