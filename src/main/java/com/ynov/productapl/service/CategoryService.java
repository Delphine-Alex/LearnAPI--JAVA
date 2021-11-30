package com.ynov.productapl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.productapl.model.Category;
import com.ynov.productapl.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category upsert(Category category) {
		return categoryRepository.save(category);
	}
	
	public Optional<Category> getCategory(Integer id){
		return categoryRepository.findById(id);
	}
	
	public Iterable<Category> getCategories(){
		return categoryRepository.findAll();
	}
	
	public void deleteCategory(Integer id){
		categoryRepository.deleteById(id);
	}

}
