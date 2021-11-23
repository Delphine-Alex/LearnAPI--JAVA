package com.ynov.productapl.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.productapl.model.Product;
import com.ynov.productapl.repository.ProductRepository;
import com.ynov.productapl.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public Iterable<Product> getProducts(){
		return productService.getProducts();
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
			Optional<Product> p = productService.getProduct(id);
			if(p.isPresent()) {
				return new ResponseEntity<Product>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	// @PostMapping("/product")
	// public Product addProduct(@RequestBody Product product) {
	//  return productRepository.save(product);
	// }
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return productService.upsert(product);
	}
	
	// @PutMapping("/product/{id}")
	// public Product Product(@RequestBody Product product) {
	//	return productRepository.save(product);
	// }
	
	@PutMapping("/product/{id}")
	public Product Product(@RequestBody Product product) {
		return productService.upsert(product);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {
		 productService.deleteProduct(id);
	}
	
	@PatchMapping("/product")
	public  ResponseEntity<Product> partialReplaceProduct(@RequestBody Product product) {
		Optional<Product> p = productService.getProduct(product.getId());
		if(p.isPresent()) {
			Product existingProduct = p.get();
		
		Product existingproduct = productService.getProduct(product.getId()).get();
		
		if(product.getName() != null
			&& !product.getName().equals(existingproduct.getName())) {
				existingproduct.setName(product.getName());
			}
		if(product.getName() != null
				&& !product.getName().equals(existingproduct.getName())) {
					existingproduct.setDescription(product.getDescription());
				}
		if(product.getName() != null
				&& !product.getName().equals(existingproduct.getName())) {
					existingproduct.setCost(product.getCost());
				}
		
		existingProduct = productService.upsert(existingProduct);
		return new ResponseEntity<Product>(existingProduct, HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/product/filter/{name}")
	public Iterable<Product> getProductsByName(@PathVariable("name") String name) {
		return productService.getProductsByname(name);
	}
}
