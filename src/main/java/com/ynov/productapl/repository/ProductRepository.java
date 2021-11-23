package com.ynov.productapl.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ynov.productapl.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	// Derived Query
	public Iterable<Product> findByName(String name);
	
	//Native query
	@Query(value = "SELECT * FROM products WHERE name = :name", nativeQuery = true)
	public Iterable<Product> findByNameNative(@Param("name") String name);
	
}