package com.parcela.parcela_server.service.impl;

import com.parcela.parcela_server.dto.LoginRequest;
import com.parcela.parcela_server.entity.Customer;
import com.parcela.parcela_server.exception.CustomException;
import com.parcela.parcela_server.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer register(Customer customer) {
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new CustomException("Email already registered");
        }
        return customerRepository.save(customer);
    }

    public Customer login(LoginRequest loginRequest) {
        if (loginRequest.isAdmin()) {
            if ("admin@parcel.com".equals(loginRequest.getEmail()) && "admin123".equals(loginRequest.getPassword())) {
                Customer admin = new Customer();
                admin.setCustId(0L);
                admin.setEmail("admin@parcel.com");
                return admin;
            }
            throw new CustomException("Invalid admin credentials");
        }
        return customerRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword())
                .orElseThrow(() -> new CustomException("Invalid credentials"));
    }
}
