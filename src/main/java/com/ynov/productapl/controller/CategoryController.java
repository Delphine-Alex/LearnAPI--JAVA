package com.ynov.productapl.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.productapl.model.Category;
import com.ynov.productapl.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category")
	public Iterable<Category> getCategories(){
		return categoryService.getCategories();
	}
	
	
	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable("id") Integer id) {
			Optional<Category> p = categoryService.getCategory(id);
			if(p.isPresent()) {
				return new ResponseEntity<Category>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/category")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.upsert(category);
	}
	
	
	@PutMapping("/category/{id}")
	public Category Category(@RequestBody Category category) {
		return categoryService.upsert(category);
	}
	
	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable("id") Integer id) {
		categoryService.deleteCategory(id);
	}
	
	
	
	
}
