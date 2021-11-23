package com.ynov.productapl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.productapl.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	
}
