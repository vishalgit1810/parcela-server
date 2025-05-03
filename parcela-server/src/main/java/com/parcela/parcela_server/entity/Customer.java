package com.parcela.parcela_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parcela.parcela_server.config.CustomerIdGenerator;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(generator = "cust_id_gen")
    @GenericGenerator(
            name = "cust_id_gen",
            type = CustomerIdGenerator.class
    )
    private Long custId;
    private String name;
    private String email;
    private String mobileNumber;
    private String address;
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking> bookings;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Payment> payments;
}