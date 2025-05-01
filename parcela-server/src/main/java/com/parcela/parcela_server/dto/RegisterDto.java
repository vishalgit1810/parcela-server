package com.parcela.parcela_server.dto;
import lombok.Data;

@Data
public class RegisterDto {
    private String name;
    private String email;
    private String mobileNumber;
    private String address;
    private String password;
}