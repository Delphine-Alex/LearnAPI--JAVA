package com.ynov.productapl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.productapl.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

	
}
