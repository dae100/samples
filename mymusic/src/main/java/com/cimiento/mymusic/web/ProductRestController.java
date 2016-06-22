package com.cimiento.mymusic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cimiento.mymusic.dto.ProductDto;
import com.cimiento.mymusic.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/rest/getAllProducts", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDto>> getAllProducts() {		
		List<ProductDto> products = productService.getAllProducts();
		return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/rest/createProduct",  method = RequestMethod.POST)
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product) {	
		productService.saveProduct(product);
		return new ResponseEntity<ProductDto>(product,HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/saveProduct",  method = RequestMethod.PUT)
	public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto product) {	
		productService.saveProduct(product);
		return new ResponseEntity<ProductDto>(product,HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/deleteProduct/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteProduct(@PathVariable Integer id) {	
		productService.deleteProduct(id);
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
}
