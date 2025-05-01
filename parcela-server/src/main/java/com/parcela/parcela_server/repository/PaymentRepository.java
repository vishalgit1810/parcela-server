package com.parcela.parcela_server.repository;

import com.parcela.parcela_server.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}