package com.parcela.parcela_server.dto;
import lombok.Data;

@Data
public class LoginRequest {
    private Long customerId;
    private String password;
}