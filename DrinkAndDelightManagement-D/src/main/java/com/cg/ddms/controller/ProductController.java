package com.cg.ddms.controller;



import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ddms.entity.ProductStock;
import com.cg.ddms.entity.Admin;
import com.cg.ddms.entity.User;
import com.cg.ddms.service.ProductService;
import com.cg.ddms.service.AdminService;
import com.cg.ddms.service.UserService;
import com.cg.ddms.service.exception.ProductException;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private AdminService sellerService;
	
	
	
	
	
	
	@PostMapping("product")
	public ResponseEntity<ProductStock> addProduct(@RequestBody ProductStock product) throws ProductException
	{
		ProductStock prod=productService.addProduct(product);
		ResponseEntity<ProductStock>  re = new ResponseEntity<ProductStock>(prod,HttpStatus.OK);

		return re;
	}
}
