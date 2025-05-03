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
        if (customerRepository.findByCustId(customer.getCustId()).isPresent()) {
            throw new CustomException("Customer ID already registered");
        }
        return customerRepository.save(customer);
    }


    public Customer login(LoginRequest loginRequest) {
        return customerRepository.findByCustIdAndPassword(loginRequest.getCustomerId(), loginRequest.getPassword())
                .orElseThrow(() -> new CustomException("Invalid credentials"));
    }
}
