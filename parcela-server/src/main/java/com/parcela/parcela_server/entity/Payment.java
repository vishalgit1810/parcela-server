package com.parcela.parcela_server.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timeDate = LocalDateTime.now();
    private double amount;
    private String status = "PENDING"; // PENDING, COMPLETED, FAILED

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Booking booking;
}
