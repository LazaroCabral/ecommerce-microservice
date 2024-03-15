package com.lzrc.productsserver.rest.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lzrc.productsserver.rest.db.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
