package com.lzrc.paymentserver.rest.dto.receipt;

import java.math.BigDecimal;

import com.lzrc.paymentserver.db.entities.Product;

public record ProductDTO(Long id, String name, BigDecimal value) {

    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getId(), product.getName(), product.getValue());
    }
}
