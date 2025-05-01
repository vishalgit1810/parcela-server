package com.parcela.parcela_server.dto;

import lombok.Data;

@Data
public class FeedbackDto {
    private Long orderId;
    private String description;
    private Long customerId;
}