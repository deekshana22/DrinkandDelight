package com.cg.ddms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ddms.entity.ProductStock;

@Repository
public interface ProductDao extends JpaRepository<ProductStock,Integer>
{
    
	
   


}
