package com.parcela.parcela_server.dto;

import lombok.Data;

@Data
public class PaymentDto {
    private Long orderId;
    private Long customerId;

    // Card details fields
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
}
