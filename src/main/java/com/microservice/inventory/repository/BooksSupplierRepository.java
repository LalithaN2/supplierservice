package com.microservice.inventory.repository;
import org.springframework.stereotype.Repository;

import com.microservice.inventory.model.BooksSupplier;

import org.springframework.data.repository.CrudRepository;


public interface BooksSupplierRepository extends CrudRepository<BooksSupplier,Long>{
	
	
	
}