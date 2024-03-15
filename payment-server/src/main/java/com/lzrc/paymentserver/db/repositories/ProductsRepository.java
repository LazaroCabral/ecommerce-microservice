package com.lzrc.paymentserver.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lzrc.paymentserver.db.entities.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long>{

}
