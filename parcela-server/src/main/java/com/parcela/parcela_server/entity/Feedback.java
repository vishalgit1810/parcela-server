package com.parcela.parcela_server.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime feedbackTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Booking booking;
}