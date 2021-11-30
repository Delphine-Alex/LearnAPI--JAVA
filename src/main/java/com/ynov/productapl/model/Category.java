package com.ynov.productapl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_category")
	private Integer id_category;
	private String name;
	
	@ManyToMany(
			fetch = FetchType.LAZY, // performance
			cascade = {
					CascadeType.PERSIST, // création
					CascadeType.MERGE }) // modification
	
	@JoinTable(
			// nom de la table de jointure
			name = "category_product",
			// clé étrangère dans la table de jointure correspondant à la clé primaire
			// de la classe courante (category)
			joinColumns = @JoinColumn(name="id_category"),
			// clé étrangère dans la table de jointure correspondant à la clé primaire
			// de la classe en relation (product)
			inverseJoinColumns = @JoinColumn(name="id_product"))
	
	private List<Product> products = new ArrayList<>();
	
	
	public Integer getId_Category() {
		return id_category;
	}
	
	public void setId_Category(Integer id_category) {
		this.id_category = id_category;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Integer getId_category() {
		return id_category;
	}

	public void setId_category(Integer id_category) {
		this.id_category = id_category;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	
	
	
}
