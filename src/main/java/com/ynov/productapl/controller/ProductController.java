package com.ynov.productapl.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getOneProduct(@PathVariable("id") Integer id) {
			Optional<Product> p = productRepository.findById(id);
			if(p.isPresent()) {
				return new ResponseEntity<Product>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteOneProduct(@PathVariable("id") Integer id) {
		 productRepository.deleteById(id);
	}
}
