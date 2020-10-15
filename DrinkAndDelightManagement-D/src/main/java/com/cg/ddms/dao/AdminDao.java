package com.cg.ddms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ddms.entity.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
	public Admin findByAdminEmail(String adminEmail);
}


