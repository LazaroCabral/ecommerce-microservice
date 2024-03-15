package com.lzrc.productsserver.rest.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lzrc.productsserver.rest.db.entities.Product;
import com.lzrc.productsserver.rest.db.repositories.ProductRepository;
import com.lzrc.productsserver.rest.dtos.entities.ProductRecord;

@RestController
public class HomeController {
	
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/")
	public String test() {
		return "<h1>Products-server TEST</h1>";
	}
	
	@GetMapping("/get-page-products/{page}")
	public List<ProductRecord> getPageProducts(@PathVariable Integer page){
		Stream<Product> products=productRepository.findAll(
			PageRequest.of(page, 12)).get();
		return ProductRecord.toRecordList(products);
	}
	
	@GetMapping("/get-product/{id}")
	public ProductRecord getProduct(@PathVariable Long id) {
		Product product=productRepository.getReferenceById(id);
		return ProductRecord.toRecord(product);
	}
	
}
