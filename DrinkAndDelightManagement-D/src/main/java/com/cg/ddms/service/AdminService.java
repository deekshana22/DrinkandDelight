package com.cg.ddms.service;

import com.cg.ddms.entity.Admin;





public interface AdminService{
	public Admin loginAdmin(String adminEmail, String adminPassword) ;

	public Admin addAdmin(Admin admin);
}
	



