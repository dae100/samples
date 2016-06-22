package com.cimiento.mymusic.service;

import java.util.List;

import com.cimiento.mymusic.dto.ProductDto;

public interface ProductService {
	List<ProductDto> getAllProducts();
	ProductDto getProduct(Integer id);
	void saveProduct(ProductDto productDto);
	void deleteProduct(Integer id);
}
