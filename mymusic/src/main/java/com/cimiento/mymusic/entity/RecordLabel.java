package com.cimiento.mymusic.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@javax.persistence.Entity
public class RecordLabel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 500, nullable = true)
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "recordLabel")
	private Set<Product> products;

	public RecordLabel() {
		
	}
	
	public RecordLabel(String name, String description)
	{
		this.name = name;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
