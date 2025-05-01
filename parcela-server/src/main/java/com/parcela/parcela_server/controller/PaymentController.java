package com.parcela.parcela_server.controller;

import com.parcela.parcela_server.dto.PaymentDto;
import com.parcela.parcela_server.entity.Payment;
import com.parcela.parcela_server.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> makePayment(@RequestBody PaymentDto paymentDto) {
        return ResponseEntity.ok(paymentService.makePayment(paymentDto));
    }
}