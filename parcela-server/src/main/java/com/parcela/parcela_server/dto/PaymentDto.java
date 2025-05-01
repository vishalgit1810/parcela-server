package com.parcela.parcela_server.dto;

import lombok.Data;

@Data
public class PaymentDto {
    private Long orderId;
    private String paymentType;
    private Long customerId;
}
