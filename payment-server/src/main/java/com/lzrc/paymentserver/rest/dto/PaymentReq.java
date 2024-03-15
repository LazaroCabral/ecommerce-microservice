package com.lzrc.paymentserver.rest.dto;

import com.lzrc.paymentserver.rest.enums.PaymentMethod;

public record PaymentReq(Long accountId, Long productId, PaymentMethod paymentMethod ) {

}
