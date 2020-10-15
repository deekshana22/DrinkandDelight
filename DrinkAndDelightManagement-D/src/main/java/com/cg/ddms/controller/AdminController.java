package com.cg.ddms.controller;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ddms.entity.Admin;
import com.cg.ddms.service.AdminService;
import com.cg.ddms.service.exception.UserNotFoundException;
/**
 * @author Deekshana
 * controller class for Admin.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Validated
public class AdminController {

	
	@Autowired
	private AdminService adminService; //autowiring admin service.
	/**
	 * Mapping for logging in as admin.
	 */
	@GetMapping("/loginAdmin/{adminEmail}/{adminPassword}")
	public ResponseEntity<Admin> loginAmin(@PathVariable @Valid @Pattern(regexp = "^(.+)@(.+)$") String adminEmail, @PathVariable String adminPassword) {
			Admin admin = adminService.loginAdmin(adminEmail, adminPassword);
			 ResponseEntity<Admin> response ;
			 try {
				 if(admin != null) {
					 response = new ResponseEntity<Admin>(admin, HttpStatus.OK);
				 } else {
					 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
					 throw new UserNotFoundException("login fail, password or email incorrectt");
				 }
			 } catch (Exception e) {
				 System.out.println("------------inside catch----------------"); //todo - change it to logger
				 throw new UserNotFoundException("login fail, password or email incorrectt");
			}
			
			return response;
		}
	
	/**
	 * Mapping for adding admin.
	 */
	
	@PostMapping("/admin/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
		Admin addedAdmin = adminService.addAdmin(admin);
		return new ResponseEntity<Admin>(addedAdmin,HttpStatus.ACCEPTED);
	}
	
	
	
}
