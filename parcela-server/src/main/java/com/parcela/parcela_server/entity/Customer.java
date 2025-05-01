package com.parcela.parcela_server.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;
    private String name;
    private String email;
    private String mobileNumber;
    private String address;
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Payment> payments;
}