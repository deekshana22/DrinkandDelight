package com.cg.ddms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ddms.dao.ProductDao;
import com.cg.ddms.entity.ProductStock;
import com.cg.ddms.service.exception.ProductException;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	
	
	@Override
	public ProductStock addProduct(ProductStock product) throws ProductException{

		ProductStock prod=productDao.saveAndFlush(product);
		
		return prod;
	}
}
