package com.cg.ddms.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ddms.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	public User findByUserEmail(String userEmail);

}
