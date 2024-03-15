package com.lzrc.productsserver.rest.dtos.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.lzrc.productsserver.rest.db.entities.Product;

public record ProductRecord(Long id, String name, String color, String description) {

	public static ProductRecord toRecord(Product product) {
		return new ProductRecord(product.getId(),product.getName(),
				product.getColor(), product.getDescription());
	}
	
	public static List<ProductRecord> toRecordList(Stream<Product> stream) {
		List<ProductRecord> productsRecords= new ArrayList<>();
		stream.forEach(product -> {
			new ProductRecord(product.getId(), product.getName(),
					product.getColor(), product.getDescription());
		});
		return productsRecords;
	}
}
