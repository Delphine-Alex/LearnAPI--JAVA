package com.ynov.productapl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.productapl.model.Product;
import com.ynov.productapl.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/product")
	public Iterable<Product> getProducts(){
		return productRepository.findAll();
	}

}
