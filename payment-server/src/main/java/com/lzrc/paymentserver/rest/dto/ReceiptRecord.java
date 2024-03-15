package com.lzrc.paymentserver.rest.dto;

import java.time.LocalDateTime;

import com.lzrc.paymentserver.rest.dto.receipt.Address;
import com.lzrc.paymentserver.rest.dto.receipt.ProductDTO;

public record ReceiptRecord(String cnpj, Address address, ProductDTO product, LocalDateTime date) {

}
