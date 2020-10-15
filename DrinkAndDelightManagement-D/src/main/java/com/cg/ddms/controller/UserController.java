package com.cg.ddms.controller;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author Deekshana
 * controller class for users.
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ddms.entity.User;
import com.cg.ddms.service.UserService;
import com.cg.ddms.service.exception.UserNotFoundException;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * Mapping for logging in as user.
	 */
	@GetMapping("/loginUser/{userEmail}/{userPassword}") 
	public ResponseEntity<User> loginUser(@PathVariable String userEmail, @PathVariable String userPassword) {
			User user = userService.loginUser(userEmail, userPassword);
			 ResponseEntity<User> response;
			 try {
				 if(user != null) {
					 response = new ResponseEntity<User>(user, HttpStatus.OK);
				 } else {
					 response = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
					 throw new UserNotFoundException("invaid credentials");
				 }
			 } catch (Exception e) {
				 response = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
				 System.out.println("---------------------inside catch----------------------");
				 throw new UserNotFoundException("invaid credentials");
			}
			 
			return response;
	}
	
	/**
	 * Mapping for adding user.
	 */
	@PostMapping("/user/addUser")
	public ResponseEntity<User> addConsumer(@RequestBody User user){
		User addedUser = userService.addUser(user);
		return new ResponseEntity<User>(addedUser,HttpStatus.ACCEPTED);
	}
}
