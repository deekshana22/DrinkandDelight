package com.cg.ddms.service;

import com.cg.ddms.entity.ProductStock;
import com.cg.ddms.service.exception.ProductException;

public interface ProductService {
	public ProductStock addProduct(ProductStock product) throws ProductException;
	
}
