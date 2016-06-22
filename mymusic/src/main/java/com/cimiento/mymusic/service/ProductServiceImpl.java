package com.cimiento.mymusic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cimiento.mymusic.dto.ProductDto;
import com.cimiento.mymusic.entity.Product;
import com.cimiento.mymusic.repository.ProductRepository;
import com.cimiento.mymusic.util.EntityTransformer;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductDto> dtoList = new ArrayList<ProductDto>();
		List<Product> products = productRepo.findAllWithArtistAndRecordLabel();
		for (Product product : products) {
			ProductDto dto = EntityTransformer.transformToProductDto(product);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public ProductDto getProduct(Integer id) {
		Product product = productRepo.findOne(id);
		ProductDto dto = EntityTransformer.transformToProductDto(product);
		return dto;
	}

	@Override
	public void saveProduct(ProductDto productDto) {
		Product product = EntityTransformer.transformToProduct(productDto);
		productRepo.saveAndFlush(product);
		if (productDto.getId() == null) productDto.setId(product.getId());	
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepo.delete(id);
		productRepo.flush();
	}

}
