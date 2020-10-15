package com.cg.ddms.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ddms.dao.AdminDao;
import com.cg.ddms.entity.Admin;




@Service
public class AdminServiceImpl implements AdminService {
	@Autowired //autowiring admin repository.
	AdminDao adminDao;
	
	/**
	 * Mapping for logging in as admin.
	 */
	@Override
	public Admin loginAdmin(String adminEmail, String adminPassword) {
    Admin admin = adminDao.findByAdminEmail(adminEmail);

	try {
		 if(admin.getAdminPassword().equals(adminPassword.toString())) {
			System.out.println("------------- password match----------------");
		}
	} catch (NullPointerException ex){
		System.out.println("------------------------ user not found with id: " + adminEmail + "----------------------");
		admin = null;
	}
    
		return admin;
	}
	
	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.save(admin);
	}

	
}
	
	
	
	
	
	
	
	
	
//	@Override
//	public Seller getSellerById(Long id) {
//		Seller seller = sellerDao.findById(id).get();
//		try {
//			if(!seller.getSellerId().equals(id)) {
//				throw new JobNotFoundException(ErrorMessageUtil.FIND_JOB_PROVIDER_ERROR);
//			}
//		} catch (JobNotFoundException e) {
//			jobProvider = null;
//		}
//		
//		return jobProvider;
//	}

