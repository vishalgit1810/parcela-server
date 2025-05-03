package com.parcela.parcela_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String receiverName;
    private String address;
    private String pincode;
    private String mobileNumber;
    private double parcelWeight;
    private String description;
    private String packingPreference;
    private LocalDateTime pickupTime;
    private LocalDateTime dropoffTime;
    private double serviceCost;
    private LocalDateTime paymentTime;
    private String orderStatus = "PENDING"; // PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED

    @ManyToOne
    @JoinColumn(name = "cust_id")
    @JsonIgnore
    private Customer customer;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonIgnore
    private Payment payment;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonIgnore
    private Feedback feedback;
}