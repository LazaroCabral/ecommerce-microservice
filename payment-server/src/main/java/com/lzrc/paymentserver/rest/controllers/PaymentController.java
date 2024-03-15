package com.lzrc.paymentserver.rest.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lzrc.paymentserver.db.entities.Product;
import com.lzrc.paymentserver.db.repositories.ProductsRepository;
import com.lzrc.paymentserver.rest.dto.PaymentReq;
import com.lzrc.paymentserver.rest.dto.ReceiptRecord;
import com.lzrc.paymentserver.rest.dto.receipt.Address;
import com.lzrc.paymentserver.rest.dto.receipt.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class PaymentController {
	
	Address address= new Address(74L,"Rua Andradas","São Paulo","Brazil");
	
	@Autowired
	ProductsRepository productsRepository;

	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/pay")
	public ReceiptRecord pay(PaymentReq paymentReq) {
		Product product=productsRepository.findById(paymentReq.productId()).get();
		return new ReceiptRecord("00.000.000/00001-00", address, ProductDTO.toDTO(product), LocalDateTime.now());
	}

	@GetMapping("/test")
	public String test() {
		return "<h1>Payment-server TEST</h1>";
	}

}
