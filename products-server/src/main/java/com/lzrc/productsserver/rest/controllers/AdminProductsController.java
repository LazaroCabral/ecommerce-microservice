package com.lzrc.productsserver.rest.controllers;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lzrc.productsserver.rest.db.entities.Product;
import com.lzrc.productsserver.rest.db.repositories.ProductRepository;

@RestController
@RequestMapping(path = "/admin")
public class AdminProductsController {
	
	@Autowired
	ProductRepository productRepository;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PutMapping("/add-product")
	public void addProducts(@RequestBody Iterable<Product> products){
		Collection<Product> productsAtt= new ArrayList<>();
		products.forEach(product -> {
			product.setDate(LocalDateTime.now());
			productsAtt.add(product);
		});
		productRepository.saveAll(productsAtt);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/delete-product")
	public void deleteProduct(@RequestBody Iterable<Long> ids){
		productRepository.deleteAllByIdInBatch(ids);
	}
}
