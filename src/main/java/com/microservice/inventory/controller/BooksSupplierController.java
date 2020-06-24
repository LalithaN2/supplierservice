package com.microservice.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.inventory.model.BooksSupplier;
import com.microservice.inventory.repository.BooksSupplierRepository;

@RestController
@RequestMapping("/supplier")
public class BooksSupplierController{
	@Autowired
	BooksSupplierRepository booksSupplierRepository;
	
	@GetMapping("/getAllSupplier")
	public List<BooksSupplier> getAllSupplier() {
		List<BooksSupplier> booksSupplierList=new ArrayList<BooksSupplier>();
	    booksSupplierRepository.findAll().forEach(lst->booksSupplierList.add(lst));		
	    return booksSupplierList;
	}
	
	@PostMapping("/saveBooksSupplier")
	public BooksSupplier saveBooksSupplier(@RequestBody BooksSupplier supplier) {
		BooksSupplier bkSupplier=booksSupplierRepository.save(supplier);
		return bkSupplier;
	}
	
	@GetMapping("/getSupplierById/{supplierId}")
	private BooksSupplier getSupplierById(@PathVariable("supplierId") Long supplierId)  {
		BooksSupplier bkSupplier= booksSupplierRepository.findById(supplierId).get();
		return bkSupplier;
	}
}